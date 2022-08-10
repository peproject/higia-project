package start.project.higia.models;

public enum ImageExamType {

	TOMOGRAFIA_DE_ABDOMEN_SEM_CONTRASTE("Tomografia de abdome sem contraste"),
	TOMOGRAFIA_DE_ABDOMEN_COM_CONTRASTE("Tomografia de abdome com contraste"),
	TOMOGRAFIA_DE_TORAX_SEM_CONTRASTE("Tomografia de tórax sem contraste"),
	TOMOGRAFIA_DE_TORAX_COM_CONTRASTE("Tomografia de tórax com contraste"),
	TOMOGRAFIA_DE_SEIOS_DA_FACE("Tomografia de seios da face"),
	TOMOGRAFIA_DE_ARTICULACAO_TEMPOROMANDIBULAR("Tomografia de articulacão temporomandibular"),
	TOMOGRAFIA_DE_MAO("Tomografia de mão"),
	TOMOGRAFIA_DE_COLUNA_CERVICAL("Tomografia de coluna cervical"),
	TOMOGRAFIA_DE_COLUNA_LOMBA("Tomografia de coluna lombar"),
	TOMOGRAFIA_DE_COLUNA_LOMBOSSACRAL("Tomografia de coluna lombossacral"),
	TOMOGRAFIA_DE_CRANIO("Tomografia de crânio"),
	RADIOGRAFIA_DE_TORAX_AP("Radiografia de tórax AP"),
	RADIOGRAFIA_DE_TORAX_PERFIL("Radiografia de tórax perfil"),
	RADIOGRAFIA_DE_TORAX_PA("Radiografia de tórax PA"),
	RADIOGRAFIA_DE_PELVE_AP("Radiografia de pelve AP"),
	RADIOGRAFIA_PA_DE_SEIOS_DA_FACE("Radiografia PA de seios da face"),
	RADIOGRAFIA_PA_DE_MANDIBULA("Radiografia PA de mandíbula"),
	RADIOGRAFIA_LATERAL_OBLIQUA_DE_MANDIBULA("Radiografia lateral oblíqua de mandíbula"),
	USG_DE_PARTES_MOLES("USG de partes moles"),
	USG_DE_ABDOMEN("USG de abdome"),
	USG_DE_CERVICAL("USG de cervical"),
	USG_DE_TIREOIDE("USG de tireoide"),
	USG_COM_DOPPLER_DE_MEMBROS_INFERIORES("USG com doppler de membros inferiores"),
	RESSONANCIA_DA_COLUNA_CERVICAL("Ressonância da coluna cervical"),
	RESSONANCIA_DA_COLUNA_LOMBAR("Ressonância da coluna lombar"),
	RESSONANCIA_DA_ARTICULACAO_TEMPOROMANDIBULAR("Ressonância da articulacão temporomandibular"),
	RESSONANCIA_DO_OMBRO("Ressonância do ombro");

	private final String displayValue;

	private ImageExamType(String displayValue) {
			this.displayValue = displayValue;
	}

	public String getDisplayValue() {
			return displayValue;
	}
}
