package fac21.gruppe1.fragen_fiesta.UtilityClasses;

public class UtilityQuestionMethods {
    public String checkQuestionType(String typeParameter){

        switch (typeParameter) {
            case "radio":
                return "radio";
                case "checkbox":
                    return "checkbox";
                    case "scale":
                        return "scale";
                        default:
                            System.out.println("TypeParameter is incorrect: " + typeParameter + "... radio, checkbox, or scale is needed");;
        }
        return null;
    }

    public boolean isRadioQuestion(String typeParameter) {
        if(typeParameter.equals("radio")){
            return true;
        } else return false;
    }

    public static boolean isCheckBoxQuestion(String typeParameter) {
        if (typeParameter.equals("checkbox")) {
            return true;
        } else return false;
    }

    public static boolean isScaleQuestion(String typeParameter) {
        if (typeParameter.equals("scale")) {
            return true;
        } else return false;
    }
}
