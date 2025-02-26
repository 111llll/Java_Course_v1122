import edu.fcps.Digit;

public class B_letter extends Digit {
    public B_letter(int x,int y){
        super(x,y);
    }
    public void display(){
        segment1_Off();
        segment2_Off();
        segment3_On();
        segment4_On();
        segment5_On();
        segment6_On();
        segment7_On();
    }
}
