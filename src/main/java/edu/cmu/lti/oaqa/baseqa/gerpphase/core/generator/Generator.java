package edu.cmu.lti.oaqa.baseqa.gerpphase.core.generator;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import edu.cmu.lti.oaqa.baseqa.data.core.TopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.Gerpable;

public interface Generator<W extends Gerpable> {

  W generate(TopWrapper<?>... gerpables) throws AnalysisEngineProcessException;

}