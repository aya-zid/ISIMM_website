package org.isimm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inginfo1Notes implements Serializable {
	@Id
	private Long CIN;
	@Column(length=100)
	private Float mathNeurOral;
	@Column(length=100)
	private Float mathNeurTP;
	@Column(length=100)
	private Float mathNeurDS;
	@Column(length=100)
	private Float mathNeurExam;
	@Column(length=100)
	private Float ProgmobileOral;
	@Column(length=100)
	private Float ProgmobileTP;
	@Column(length=100)
	private Float ProgmobileDS;
	@Column(length=100)
	private Float ProgmobileExam;
	@Column(length=100)
	private Float JavaCardOral;
	@Column(length=100)
	private Float JavaCardTP;
	@Column(length=100)
	private Float JavaCardDS;
	@Column(length=100)
	private Float JavaCardExam;
	@Column(length=100)
	private Float UMLOral;
	@Column(length=100)
	private Float UMLTP;
	private Float UMLDS;
	@Column(length=100)
	private Float UMLExam;
	@Column(length=100)
	private Float ProgWebeOral;
	@Column(length=100)
	private Float ProgWebTP;
	@Column(length=100)
	private Float ProgWebDS;
	@Column(length=100)
	private Float ProgWebExam;
	@Column(length=100)
	private Float PythonOral;
	@Column(length=100)
	private Float PythonTP;
	@Column(length=100)
	private Float PythonDS;
	@Column(length=100)
	private Float PythonExam;
	@Column(length=100)
	private Float AnalyseDataOral;
	@Column(length=100)
	private Float AnalyseDataTP;
	@Column(length=100)
	private Float AnalyseDataDS;
	@Column(length=100)
	private Float AnalyseDataExam;
	@Column(length=100)
	private Float LexicoOral;
	@Column(length=100)
	private Float LexicoTP;
	@Column(length=100)
	private Float LexicoDS;
	@Column(length=100)
	private Float LexicoExam;
	@Column(length=100)
	private Float English1Oral;
	@Column(length=100)
	private Float English1TP;
	@Column(length=100)
	private Float English1DS;
	@Column(length=100)
	private Float English1Exam;
	@Column(length=100)
	private Float French1Oral;
	@Column(length=100)
	private Float French1TP;
	@Column(length=100)
	private Float French1DS;
	@Column(length=100)
	private Float French1Exam;
	@Column(length=100)
	private Float Communic1Oral;
	@Column(length=100)
	private Float Communic1TP;
	@Column(length=100)
	private Float Communic1DS;
	@Column(length=100)
	private Float Communic1Exam;
	@Column(length=100)
	private Float StochaOral;
	@Column(length=100)
	private Float StochaTP;
	@Column(length=100)
	private Float StochaDS;
	@Column(length=100)
	private Float StochaExam;
	@Column(length=100)
	private Float FramaOral;
	@Column(length=100)
	private Float FramaTP;
	@Column(length=100)
	private Float FramaDS;
	@Column(length=100)
	private Float FramaExam;
	@Column(length=100)
	private Float MLOral;
	@Column(length=100)
	private Float MLTP;
	@Column(length=100)
	private Float MLDS;
	@Column(length=100)
	private Float MLExam;
	@Column(length=100)
	private Float AIOral;
	@Column(length=100)
	private Float AITP;
	@Column(length=100)
	private Float AIDS;
	@Column(length=100)
	private Float AIExam;
	@Column(length=100)
	private Float OptimOral;
	@Column(length=100)
	private Float OptimTP;
	@Column(length=100)
	private Float OptimDS;
	@Column(length=100)
	private Float OptimExam;
	@Column(length=100)
	private Float ConceptionOral;
	@Column(length=100)
	private Float ConceptionTP;
	@Column(length=100)
	private Float ConceptionDS;
	@Column(length=100)
	private Float ConceptionExam;
	@Column(length=100)
	private Float SIOral;
	@Column(length=100)
	private Float SITP;
	@Column(length=100)
	private Float SIDS;
	@Column(length=100)
	private Float SIExam;
	@Column(length=100)
	private Float English2Oral;
	@Column(length=100)
	private Float English2TP;
	@Column(length=100)
	private Float English2DS;
	@Column(length=100)
	private Float English2Exam;
	@Column(length=100)
	private Float French2Oral;
	@Column(length=100)
	private Float French2TP;
	@Column(length=100)
	private Float French2DS;
	@Column(length=100)
	private Float French2Exam;
	@Column(length=100)
	private Float Communic2Oral;
	@Column(length=100)
	private Float Communic2TP;
	@Column(length=100)
	private Float Communic2DS;
	@Column(length=100)
	private Float Communic2Exam;
	@Column(length=100)
	private Float ProjetWebOral;
	@Column(length=100)
	private Float ProjetWebTP;
	@Column(length=100)
	private Float ProjetWebDS;
	@Column(length=100)
	private Float ProjetWebExam;
	@Column(length=100)
	private Float ProjetSIOral;
	@Column(length=100)
	private Float ProjetSITP;
	@Column(length=100)
	private Float ProjetSIDS;
	@Column(length=100)
	private Float ProjetSIExam;
	public Long getCIN() {
		return CIN;
	}
	public void setCIN(Long cIN) {
		CIN = cIN;
	}
	public Float getMathNeurOral() {
		return mathNeurOral;
	}
	public void setMathNeurOral(Float mathNeurOral) {
		this.mathNeurOral = mathNeurOral;
	}
	public Float getMathNeurTP() {
		return mathNeurTP;
	}
	public void setMathNeurTP(Float mathNeurTP) {
		this.mathNeurTP = mathNeurTP;
	}
	public Float getMathNeurDS() {
		return mathNeurDS;
	}
	public void setMathNeurDS(Float mathNeurDS) {
		this.mathNeurDS = mathNeurDS;
	}
	public Float getMathNeurExam() {
		return mathNeurExam;
	}
	public void setMathNeurExam(Float mathNeurExam) {
		this.mathNeurExam = mathNeurExam;
	}
	public Float getProgmobileOral() {
		return ProgmobileOral;
	}
	public void setProgmobileOral(Float progmobileOral) {
		ProgmobileOral = progmobileOral;
	}
	public Float getProgmobileTP() {
		return ProgmobileTP;
	}
	public void setProgmobileTP(Float progmobileTP) {
		ProgmobileTP = progmobileTP;
	}
	public Float getProgmobileDS() {
		return ProgmobileDS;
	}
	public void setProgmobileDS(Float progmobileDS) {
		ProgmobileDS = progmobileDS;
	}
	public Float getProgmobileExam() {
		return ProgmobileExam;
	}
	public void setProgmobileExam(Float progmobileExam) {
		ProgmobileExam = progmobileExam;
	}
	public Float getJavaCardOral() {
		return JavaCardOral;
	}
	public void setJavaCardOral(Float javaCardOral) {
		JavaCardOral = javaCardOral;
	}
	public Float getJavaCardTP() {
		return JavaCardTP;
	}
	public void setJavaCardTP(Float javaCardTP) {
		JavaCardTP = javaCardTP;
	}
	public Float getJavaCardDS() {
		return JavaCardDS;
	}
	public void setJavaCardDS(Float javaCardDS) {
		JavaCardDS = javaCardDS;
	}
	public Float getJavaCardExam() {
		return JavaCardExam;
	}
	public void setJavaCardExam(Float javaCardExam) {
		JavaCardExam = javaCardExam;
	}
	public Float getUMLOral() {
		return UMLOral;
	}
	public void setUMLOral(Float uMLOral) {
		UMLOral = uMLOral;
	}
	public Float getUMLTP() {
		return UMLTP;
	}
	public void setUMLTP(Float uMLTP) {
		UMLTP = uMLTP;
	}
	public Float getUMLDS() {
		return UMLDS;
	}
	public void setUMLDS(Float uMLDS) {
		UMLDS = uMLDS;
	}
	public Float getUMLExam() {
		return UMLExam;
	}
	public void setUMLExam(Float uMLExam) {
		UMLExam = uMLExam;
	}
	public Float getProgWebeOral() {
		return ProgWebeOral;
	}
	public void setProgWebeOral(Float progWebeOral) {
		ProgWebeOral = progWebeOral;
	}
	public Float getProgWebTP() {
		return ProgWebTP;
	}
	public void setProgWebTP(Float progWebTP) {
		ProgWebTP = progWebTP;
	}
	public Float getProgWebDS() {
		return ProgWebDS;
	}
	public void setProgWebDS(Float progWebDS) {
		ProgWebDS = progWebDS;
	}
	public Float getProgWebExam() {
		return ProgWebExam;
	}
	public void setProgWebExam(Float progWebExam) {
		ProgWebExam = progWebExam;
	}
	public Float getPythonOral() {
		return PythonOral;
	}
	public void setPythonOral(Float pythonOral) {
		PythonOral = pythonOral;
	}
	public Float getPythonTP() {
		return PythonTP;
	}
	public void setPythonTP(Float pythonTP) {
		PythonTP = pythonTP;
	}
	public Float getPythonDS() {
		return PythonDS;
	}
	public void setPythonDS(Float pythonDS) {
		PythonDS = pythonDS;
	}
	public Float getPythonExam() {
		return PythonExam;
	}
	public void setPythonExam(Float pythonExam) {
		PythonExam = pythonExam;
	}
	public Float getAnalyseDataOral() {
		return AnalyseDataOral;
	}
	public void setAnalyseDataOral(Float analyseDataOral) {
		AnalyseDataOral = analyseDataOral;
	}
	public Float getAnalyseDataTP() {
		return AnalyseDataTP;
	}
	public void setAnalyseDataTP(Float analyseDataTP) {
		AnalyseDataTP = analyseDataTP;
	}
	public Float getAnalyseDataDS() {
		return AnalyseDataDS;
	}
	public void setAnalyseDataDS(Float analyseDataDS) {
		AnalyseDataDS = analyseDataDS;
	}
	public Float getAnalyseDataExam() {
		return AnalyseDataExam;
	}
	public void setAnalyseDataExam(Float analyseDataExam) {
		AnalyseDataExam = analyseDataExam;
	}
	public Float getLexicoOral() {
		return LexicoOral;
	}
	public void setLexicoOral(Float lexicoOral) {
		LexicoOral = lexicoOral;
	}
	public Float getLexicoTP() {
		return LexicoTP;
	}
	public void setLexicoTP(Float lexicoTP) {
		LexicoTP = lexicoTP;
	}
	public Float getLexicoDS() {
		return LexicoDS;
	}
	public void setLexicoDS(Float lexicoDS) {
		LexicoDS = lexicoDS;
	}
	public Float getLexicoExam() {
		return LexicoExam;
	}
	public void setLexicoExam(Float lexicoExam) {
		LexicoExam = lexicoExam;
	}
	public Float getEnglish1Oral() {
		return English1Oral;
	}
	public void setEnglish1Oral(Float english1Oral) {
		English1Oral = english1Oral;
	}
	public Float getEnglish1TP() {
		return English1TP;
	}
	public void setEnglish1TP(Float english1tp) {
		English1TP = english1tp;
	}
	public Float getEnglish1DS() {
		return English1DS;
	}
	public void setEnglish1DS(Float english1ds) {
		English1DS = english1ds;
	}
	public Float getEnglish1Exam() {
		return English1Exam;
	}
	public void setEnglish1Exam(Float english1Exam) {
		English1Exam = english1Exam;
	}
	public Float getFrench1Oral() {
		return French1Oral;
	}
	public void setFrench1Oral(Float french1Oral) {
		French1Oral = french1Oral;
	}
	public Float getFrench1TP() {
		return French1TP;
	}
	public void setFrench1TP(Float french1tp) {
		French1TP = french1tp;
	}
	public Float getFrench1DS() {
		return French1DS;
	}
	public void setFrench1DS(Float french1ds) {
		French1DS = french1ds;
	}
	public Float getFrench1Exam() {
		return French1Exam;
	}
	public void setFrench1Exam(Float french1Exam) {
		French1Exam = french1Exam;
	}
	public Float getCommunic1Oral() {
		return Communic1Oral;
	}
	public void setCommunic1Oral(Float communic1Oral) {
		Communic1Oral = communic1Oral;
	}
	public Float getCommunic1TP() {
		return Communic1TP;
	}
	public void setCommunic1TP(Float communic1tp) {
		Communic1TP = communic1tp;
	}
	public Float getCommunic1DS() {
		return Communic1DS;
	}
	public void setCommunic1DS(Float communic1ds) {
		Communic1DS = communic1ds;
	}
	public Float getCommunic1Exam() {
		return Communic1Exam;
	}
	public void setCommunic1Exam(Float communic1Exam) {
		Communic1Exam = communic1Exam;
	}
	public Float getStochaOral() {
		return StochaOral;
	}
	public void setStochaOral(Float stochaOral) {
		StochaOral = stochaOral;
	}
	public Float getStochaTP() {
		return StochaTP;
	}
	public void setStochaTP(Float stochaTP) {
		StochaTP = stochaTP;
	}
	public Float getStochaDS() {
		return StochaDS;
	}
	public void setStochaDS(Float stochaDS) {
		StochaDS = stochaDS;
	}
	public Float getStochaExam() {
		return StochaExam;
	}
	public void setStochaExam(Float stochaExam) {
		StochaExam = stochaExam;
	}
	public Float getFramaOral() {
		return FramaOral;
	}
	public void setFramaOral(Float framaOral) {
		FramaOral = framaOral;
	}
	public Float getFramaTP() {
		return FramaTP;
	}
	public void setFramaTP(Float framaTP) {
		FramaTP = framaTP;
	}
	public Float getFramaDS() {
		return FramaDS;
	}
	public void setFramaDS(Float framaDS) {
		FramaDS = framaDS;
	}
	public Float getFramaExam() {
		return FramaExam;
	}
	public void setFramaExam(Float framaExam) {
		FramaExam = framaExam;
	}
	public Float getMLOral() {
		return MLOral;
	}
	public void setMLOral(Float mLOral) {
		MLOral = mLOral;
	}
	public Float getMLTP() {
		return MLTP;
	}
	public void setMLTP(Float mLTP) {
		MLTP = mLTP;
	}
	public Float getMLDS() {
		return MLDS;
	}
	public void setMLDS(Float mLDS) {
		MLDS = mLDS;
	}
	public Float getMLExam() {
		return MLExam;
	}
	public void setMLExam(Float mLExam) {
		MLExam = mLExam;
	}
	public Float getAIOral() {
		return AIOral;
	}
	public void setAIOral(Float aIOral) {
		AIOral = aIOral;
	}
	public Float getAITP() {
		return AITP;
	}
	public void setAITP(Float aITP) {
		AITP = aITP;
	}
	public Float getAIDS() {
		return AIDS;
	}
	public void setAIDS(Float aIDS) {
		AIDS = aIDS;
	}
	public Float getAIExam() {
		return AIExam;
	}
	public void setAIExam(Float aIExam) {
		AIExam = aIExam;
	}
	public Float getOptimOral() {
		return OptimOral;
	}
	public void setOptimOral(Float optimOral) {
		OptimOral = optimOral;
	}
	public Float getOptimTP() {
		return OptimTP;
	}
	public void setOptimTP(Float optimTP) {
		OptimTP = optimTP;
	}
	public Float getOptimDS() {
		return OptimDS;
	}
	public void setOptimDS(Float optimDS) {
		OptimDS = optimDS;
	}
	public Float getOptimExam() {
		return OptimExam;
	}
	public void setOptimExam(Float optimExam) {
		OptimExam = optimExam;
	}
	public Float getConceptionOral() {
		return ConceptionOral;
	}
	public void setConceptionOral(Float conceptionOral) {
		ConceptionOral = conceptionOral;
	}
	public Float getConceptionTP() {
		return ConceptionTP;
	}
	public void setConceptionTP(Float conceptionTP) {
		ConceptionTP = conceptionTP;
	}
	public Float getConceptionDS() {
		return ConceptionDS;
	}
	public void setConceptionDS(Float conceptionDS) {
		ConceptionDS = conceptionDS;
	}
	public Float getConceptionExam() {
		return ConceptionExam;
	}
	public void setConceptionExam(Float conceptionExam) {
		ConceptionExam = conceptionExam;
	}
	public Float getSIOral() {
		return SIOral;
	}
	public void setSIOral(Float sIOral) {
		SIOral = sIOral;
	}
	public Float getSITP() {
		return SITP;
	}
	public void setSITP(Float sITP) {
		SITP = sITP;
	}
	public Float getSIDS() {
		return SIDS;
	}
	public void setSIDS(Float sIDS) {
		SIDS = sIDS;
	}
	public Float getSIExam() {
		return SIExam;
	}
	public void setSIExam(Float sIExam) {
		SIExam = sIExam;
	}
	public Float getEnglish2Oral() {
		return English2Oral;
	}
	public void setEnglish2Oral(Float english2Oral) {
		English2Oral = english2Oral;
	}
	public Float getEnglish2TP() {
		return English2TP;
	}
	public void setEnglish2TP(Float english2tp) {
		English2TP = english2tp;
	}
	public Float getEnglish2DS() {
		return English2DS;
	}
	public void setEnglish2DS(Float english2ds) {
		English2DS = english2ds;
	}
	public Float getEnglish2Exam() {
		return English2Exam;
	}
	public void setEnglish2Exam(Float english2Exam) {
		English2Exam = english2Exam;
	}
	public Float getFrench2Oral() {
		return French2Oral;
	}
	public void setFrench2Oral(Float french2Oral) {
		French2Oral = french2Oral;
	}
	public Float getFrench2TP() {
		return French2TP;
	}
	public void setFrench2TP(Float french2tp) {
		French2TP = french2tp;
	}
	public Float getFrench2DS() {
		return French2DS;
	}
	public void setFrench2DS(Float french2ds) {
		French2DS = french2ds;
	}
	public Float getFrench2Exam() {
		return French2Exam;
	}
	public void setFrench2Exam(Float french2Exam) {
		French2Exam = french2Exam;
	}
	public Float getCommunic2Oral() {
		return Communic2Oral;
	}
	public void setCommunic2Oral(Float communic2Oral) {
		Communic2Oral = communic2Oral;
	}
	public Float getCommunic2TP() {
		return Communic2TP;
	}
	public void setCommunic2TP(Float communic2tp) {
		Communic2TP = communic2tp;
	}
	public Float getCommunic2DS() {
		return Communic2DS;
	}
	public void setCommunic2DS(Float communic2ds) {
		Communic2DS = communic2ds;
	}
	public Float getCommunic2Exam() {
		return Communic2Exam;
	}
	public void setCommunic2Exam(Float communic2Exam) {
		Communic2Exam = communic2Exam;
	}
	public Float getProjetWebOral() {
		return ProjetWebOral;
	}
	public void setProjetWebOral(Float projetWebOral) {
		ProjetWebOral = projetWebOral;
	}
	public Float getProjetWebTP() {
		return ProjetWebTP;
	}
	public void setProjetWebTP(Float projetWebTP) {
		ProjetWebTP = projetWebTP;
	}
	public Float getProjetWebDS() {
		return ProjetWebDS;
	}
	public void setProjetWebDS(Float projetWebDS) {
		ProjetWebDS = projetWebDS;
	}
	public Float getProjetWebExam() {
		return ProjetWebExam;
	}
	public void setProjetWebExam(Float projetWebExam) {
		ProjetWebExam = projetWebExam;
	}
	public Float getProjetSIOral() {
		return ProjetSIOral;
	}
	public void setProjetSIOral(Float projetSIOral) {
		ProjetSIOral = projetSIOral;
	}
	public Float getProjetSITP() {
		return ProjetSITP;
	}
	public void setProjetSITP(Float projetSITP) {
		ProjetSITP = projetSITP;
	}
	public Float getProjetSIDS() {
		return ProjetSIDS;
	}
	public void setProjetSIDS(Float projetSIDS) {
		ProjetSIDS = projetSIDS;
	}
	public Float getProjetSIExam() {
		return ProjetSIExam;
	}
	public void setProjetSIExam(Float projetSIExam) {
		ProjetSIExam = projetSIExam;
	}
	public Inginfo1Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inginfo1Notes(Long cIN, Float mathNeurOral, Float mathNeurTP, Float mathNeurDS, Float mathNeurExam,
			Float progmobileOral, Float progmobileTP, Float progmobileDS, Float progmobileExam, Float javaCardOral,
			Float javaCardTP, Float javaCardDS, Float javaCardExam, Float uMLOral, Float uMLTP, Float uMLDS,
			Float uMLExam, Float progWebeOral, Float progWebTP, Float progWebDS, Float progWebExam, Float pythonOral,
			Float pythonTP, Float pythonDS, Float pythonExam, Float analyseDataOral, Float analyseDataTP,
			Float analyseDataDS, Float analyseDataExam, Float lexicoOral, Float lexicoTP, Float lexicoDS,
			Float lexicoExam, Float english1Oral, Float english1tp, Float english1ds, Float english1Exam,
			Float french1Oral, Float french1tp, Float french1ds, Float french1Exam, Float communic1Oral,
			Float communic1tp, Float communic1ds, Float communic1Exam, Float stochaOral, Float stochaTP, Float stochaDS,
			Float stochaExam, Float framaOral, Float framaTP, Float framaDS, Float framaExam, Float mLOral, Float mLTP,
			Float mLDS, Float mLExam, Float aIOral, Float aITP, Float aIDS, Float aIExam, Float optimOral,
			Float optimTP, Float optimDS, Float optimExam, Float conceptionOral, Float conceptionTP, Float conceptionDS,
			Float conceptionExam, Float sIOral, Float sITP, Float sIDS, Float sIExam, Float english2Oral,
			Float english2tp, Float english2ds, Float english2Exam, Float french2Oral, Float french2tp, Float french2ds,
			Float french2Exam, Float communic2Oral, Float communic2tp, Float communic2ds, Float communic2Exam,
			Float projetWebOral, Float projetWebTP, Float projetWebDS, Float projetWebExam, Float projetSIOral,
			Float projetSITP, Float projetSIDS, Float projetSIExam) {
		super();
		CIN = cIN;
		this.mathNeurOral = mathNeurOral;
		this.mathNeurTP = mathNeurTP;
		this.mathNeurDS = mathNeurDS;
		this.mathNeurExam = mathNeurExam;
		ProgmobileOral = progmobileOral;
		ProgmobileTP = progmobileTP;
		ProgmobileDS = progmobileDS;
		ProgmobileExam = progmobileExam;
		JavaCardOral = javaCardOral;
		JavaCardTP = javaCardTP;
		JavaCardDS = javaCardDS;
		JavaCardExam = javaCardExam;
		UMLOral = uMLOral;
		UMLTP = uMLTP;
		UMLDS = uMLDS;
		UMLExam = uMLExam;
		ProgWebeOral = progWebeOral;
		ProgWebTP = progWebTP;
		ProgWebDS = progWebDS;
		ProgWebExam = progWebExam;
		PythonOral = pythonOral;
		PythonTP = pythonTP;
		PythonDS = pythonDS;
		PythonExam = pythonExam;
		AnalyseDataOral = analyseDataOral;
		AnalyseDataTP = analyseDataTP;
		AnalyseDataDS = analyseDataDS;
		AnalyseDataExam = analyseDataExam;
		LexicoOral = lexicoOral;
		LexicoTP = lexicoTP;
		LexicoDS = lexicoDS;
		LexicoExam = lexicoExam;
		English1Oral = english1Oral;
		English1TP = english1tp;
		English1DS = english1ds;
		English1Exam = english1Exam;
		French1Oral = french1Oral;
		French1TP = french1tp;
		French1DS = french1ds;
		French1Exam = french1Exam;
		Communic1Oral = communic1Oral;
		Communic1TP = communic1tp;
		Communic1DS = communic1ds;
		Communic1Exam = communic1Exam;
		StochaOral = stochaOral;
		StochaTP = stochaTP;
		StochaDS = stochaDS;
		StochaExam = stochaExam;
		FramaOral = framaOral;
		FramaTP = framaTP;
		FramaDS = framaDS;
		FramaExam = framaExam;
		MLOral = mLOral;
		MLTP = mLTP;
		MLDS = mLDS;
		MLExam = mLExam;
		AIOral = aIOral;
		AITP = aITP;
		AIDS = aIDS;
		AIExam = aIExam;
		OptimOral = optimOral;
		OptimTP = optimTP;
		OptimDS = optimDS;
		OptimExam = optimExam;
		ConceptionOral = conceptionOral;
		ConceptionTP = conceptionTP;
		ConceptionDS = conceptionDS;
		ConceptionExam = conceptionExam;
		SIOral = sIOral;
		SITP = sITP;
		SIDS = sIDS;
		SIExam = sIExam;
		English2Oral = english2Oral;
		English2TP = english2tp;
		English2DS = english2ds;
		English2Exam = english2Exam;
		French2Oral = french2Oral;
		French2TP = french2tp;
		French2DS = french2ds;
		French2Exam = french2Exam;
		Communic2Oral = communic2Oral;
		Communic2TP = communic2tp;
		Communic2DS = communic2ds;
		Communic2Exam = communic2Exam;
		ProjetWebOral = projetWebOral;
		ProjetWebTP = projetWebTP;
		ProjetWebDS = projetWebDS;
		ProjetWebExam = projetWebExam;
		ProjetSIOral = projetSIOral;
		ProjetSITP = projetSITP;
		ProjetSIDS = projetSIDS;
		ProjetSIExam = projetSIExam;
	}
	
	
}
