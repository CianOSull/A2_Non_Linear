/*
 * Author: Cian O'Sullivan
 */
public class myMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option = 3;
		int n = 3;
		
		if(option == 1) {
			PaperRollCuttingBottomUp p = new PaperRollCuttingBottomUp(n);
			p.solve();
			p.printSol();
		}
		else if(option == 2) {
			RobotMoving r = new RobotMoving(n, "O");
			r.solve();
			r.printSol();
		}
		else {
			Bishops b = new Bishops(n);
			b.solve();
		}
	}

}
