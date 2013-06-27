package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.retrieval.SearchResult;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.answer.CandidateAnswerVariantWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpTopWrapper;

public abstract class SearchResultWrapper<T extends SearchResult> extends GerpTopWrapper<T> {

  private static final long serialVersionUID = 1L;

  private String uri;

  private float score;

  private String text;

  private int rank;

  private String queryString;

  private String searchId;

  private List<CandidateAnswerVariantWrapper> candidateAnswers;

  public SearchResultWrapper(String uri, float score, String text, int rank, String queryString,
          String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers) {
    super();
    this.uri = uri;
    this.score = score;
    this.text = text;
    this.rank = rank;
    this.queryString = queryString;
    this.searchId = searchId;
    this.candidateAnswers = candidateAnswers;
  }

  public SearchResultWrapper(String uri, float score, String text, int rank, String queryString,
          String searchId, List<CandidateAnswerVariantWrapper> candidateAnswers, String generator) {
    super(generator);
    this.uri = uri;
    this.score = score;
    this.text = text;
    this.rank = rank;
    this.queryString = queryString;
    this.searchId = searchId;
    this.candidateAnswers = candidateAnswers;
  }

  @Override
  public void wrap(T top) throws AnalysisEngineProcessException {
    super.wrap(top);
    this.uri = top.getUri();
    this.score = top.getScore();
    this.text = top.getText();
    this.rank = top.getRank();
    this.queryString = top.getQueryString();
    this.searchId = top.getSearchId();
    this.candidateAnswers = WrapperHelper.wrapTopArray(top.getCandidateAnswers(),
            CandidateAnswerVariantWrapper.class);
  }

  @Override
  public T unwrap(JCas jcas) throws AnalysisEngineProcessException {
    T top = super.unwrap(jcas);
    top.setUri(uri);
    top.setScore(score);
    top.setText(text);
    top.setRank(rank);
    top.setQueryString(queryString);
    top.setSearchId(searchId);
    top.setCandidateAnswers(WrapperHelper.unwrapTopArray(candidateAnswers, jcas));
    return top;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), uri, queryString, searchId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    @SuppressWarnings("unchecked")
    SearchResultWrapper<T> other = (SearchResultWrapper<T>) obj;
    return Objects.equal(uri, other.uri) && Objects.equal(queryString, other.queryString)
            && Objects.equal(searchId, other.searchId);
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public float getScore() {
    return score;
  }

  public void setScore(float score) {
    this.score = score;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public String getQueryString() {
    return queryString;
  }

  public void setQueryString(String queryString) {
    this.queryString = queryString;
  }

  public String getSearchId() {
    return searchId;
  }

  public void setSearchId(String searchId) {
    this.searchId = searchId;
  }

  public List<CandidateAnswerVariantWrapper> getCandidateAnswers() {
    return candidateAnswers;
  }

  public void setCandidateAnswers(List<CandidateAnswerVariantWrapper> candidateAnswers) {
    this.candidateAnswers = candidateAnswers;
  }

}