/*
 *  Copyright 2013 Carnegie Mellon University
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package edu.cmu.lti.oaqa.framework.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.jcas.JCas;
import org.oaqa.model.Passage;
import org.oaqa.model.Search;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.data.base.FSArrayWrapper;

public class RetrievalResultArray extends FSArrayWrapper<Passage> {

  public RetrievalResultArray(JCas jcas, int length) {
    super(jcas, length);
  }

  @Override
  public void clear() {
    Iterator<?> it = jcas.getJFSIndexRepository().getAllIndexedFS(Search.type);
    while (it.hasNext()) {
      Search search = (Search) it.next();
      search.removeFromIndexes();
    }
  }

  @Override
  public void complete() {
    Search search = new Search(jcas);
    search.setHitList(array);
    search.addToIndexes();
  }

  public void setRetrievalResults(List<RetrievalResult> results) throws Exception {
    Collections.sort(results, Collections.reverseOrder());
    double prevScore = Double.NaN;
    int prevRank = 0;
    for (int i = 0; i < results.size(); i++) {
      RetrievalResult result = results.get(i);
      double curScore = result.getProbability();
      if (curScore != prevScore) {
        result.setRank(i + 1);
        prevScore = curScore;
        prevRank = i + 1;
      } else {
        result.setRank(prevRank);
      }
    }
    setArray(results);
  }

  public static void storeRetrievalResults(JCas jcas, List<RetrievalResult> results)
          throws Exception {
    new RetrievalResultArray(jcas, results.size()).setRetrievalResults(results);
  }

  public List<RetrievalResult> getRetrievalResults() throws Exception {
    Search search = (Search) BaseJCasHelper.getFS(jcas, Search.type);
    if (search != null) {
      array = search.getHitList();
      return getArray(Passage.class, RetrievalResult.class);
    } else {
      return new ArrayList<RetrievalResult>();
    }
  }

  public static List<RetrievalResult> retrieveRetrievalResults(JCas jcas) throws Exception {
    return new RetrievalResultArray(jcas, 0).getRetrievalResults();
  }

}
