

/* First created by JCasGen Sun Oct 05 18:02:25 EDT 2014 */
package edu.cmu.lti.oaqa.type.answer;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.cas.StringList;


/** A short summary of ideal answer generated by the QA system.
 * Updated by JCasGen Mon Oct 06 20:47:17 EDT 2014
 * XML source: /home/yangzi/QA/baseqa/src/main/resources/baseqa/type/OAQATypes.xml
 * @generated */
public class Summary extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Summary.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Summary() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Summary(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Summary(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The actual answer string.
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (Summary_Type.featOkTst && ((Summary_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.answer.Summary");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Summary_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The actual answer string. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (Summary_Type.featOkTst && ((Summary_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.oaqa.type.answer.Summary");
    jcasType.ll_cas.ll_setStringValue(addr, ((Summary_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: variants

  /** getter for variants - gets List of candidate answer variant ids that were merged into this final answer.
   * @generated
   * @return value of the feature 
   */
  public StringList getVariants() {
    if (Summary_Type.featOkTst && ((Summary_Type)jcasType).casFeat_variants == null)
      jcasType.jcas.throwFeatMissing("variants", "edu.cmu.lti.oaqa.type.answer.Summary");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Summary_Type)jcasType).casFeatCode_variants)));}
    
  /** setter for variants - sets List of candidate answer variant ids that were merged into this final answer. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setVariants(StringList v) {
    if (Summary_Type.featOkTst && ((Summary_Type)jcasType).casFeat_variants == null)
      jcasType.jcas.throwFeatMissing("variants", "edu.cmu.lti.oaqa.type.answer.Summary");
    jcasType.ll_cas.ll_setRefValue(addr, ((Summary_Type)jcasType).casFeatCode_variants, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: rank

  /** getter for rank - gets Rank of this result in the original hit-list.
   * @generated
   * @return value of the feature 
   */
  public int getRank() {
    if (Summary_Type.featOkTst && ((Summary_Type)jcasType).casFeat_rank == null)
      jcasType.jcas.throwFeatMissing("rank", "edu.cmu.lti.oaqa.type.answer.Summary");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Summary_Type)jcasType).casFeatCode_rank);}
    
  /** setter for rank - sets Rank of this result in the original hit-list. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRank(int v) {
    if (Summary_Type.featOkTst && ((Summary_Type)jcasType).casFeat_rank == null)
      jcasType.jcas.throwFeatMissing("rank", "edu.cmu.lti.oaqa.type.answer.Summary");
    jcasType.ll_cas.ll_setIntValue(addr, ((Summary_Type)jcasType).casFeatCode_rank, v);}    
  }

    