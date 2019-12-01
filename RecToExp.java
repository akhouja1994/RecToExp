
public class RecToExp {

	public RecToExp(double n ,double condA/*a(n-2)*/,double condB/*a(n-1)*/,double xFactor /*which is a in this eq(x^2+ax+b)*/, double constant/*which is b in this eq(x^2+ax+b)*/ ) {
		
		double [] uvArray = twoEq(n ,condA,condB,rootsFinder (xFactor,constant));
		double [] roots = rootsFinder (xFactor,constant);
		// TODO Auto-generated constructor stub
		if (roots[0] == roots[1])
			System.out.printf("an = %f(%f^n)+ %f*n(%f^n)",uvArray[0],roots[0],uvArray[1],roots[1]);
		else
			System.out.printf("an = %f(%f^n)+%f(%f^n)",uvArray[0],roots[0],uvArray[1],roots[1]);
	}
	public double [] rootsFinder (double xFactor , double constant){
		double roots [] = {1,2};
		roots[0] = ((-xFactor+ Math.sqrt(xFactor*xFactor-4*constant))/2);
		roots[1] = ((-xFactor- Math.sqrt(xFactor*xFactor-4*constant))/2);
		return roots;
	};
	public double [] twoEq(double n ,double condA, double condB, double roots[]){
		if(roots[0] != roots[1]) {
			double uCoffEq1 = Math.pow(roots[0],(n-2));
			double vCoffEq1 = Math.pow(roots[1],(n-2));
			double uCoffEq2 = Math.pow(roots[0],(n-1));
			double vCoffEq2 = Math.pow(roots[1],(n-1));
			double matrixOfV [][] = {{uCoffEq1,condA},{uCoffEq2,condB}};
			double matrixOfU [][] = {{condA,vCoffEq1},{condB,vCoffEq2}};
			double matrixOfUV [][] = {{uCoffEq1,vCoffEq1},{uCoffEq2,vCoffEq2}};
			double dMatrixOfU = determinant(matrixOfU);
			double dMatrixOfV = determinant(matrixOfV);
			double dMatrixOfUV = determinant(matrixOfUV);
			double u = (dMatrixOfU/dMatrixOfUV);
			double v = (dMatrixOfV/dMatrixOfUV);
			double [] uvArray = {u,v};
			return uvArray;
		}
		else {
			double uCoffEq1 = Math.pow(roots[0],(n-2));
			double vCoffEq1 = Math.pow(roots[1],(n-2))*(n-2);
			double uCoffEq2 = Math.pow(roots[0],(n-1));
			double vCoffEq2 = Math.pow(roots[1],(n-1))*(n-1);
			double matrixOfV [][] = {{uCoffEq1,condA},{uCoffEq2,condB}};
			double matrixOfU [][] = {{condA,vCoffEq1},{condB,vCoffEq2}};
			double matrixOfUV [][] = {{uCoffEq1,vCoffEq1},{uCoffEq2,vCoffEq2}};
			double dMatrixOfU = determinant(matrixOfU);
			double dMatrixOfV = determinant(matrixOfV);
			double dMatrixOfUV = determinant(matrixOfUV);
			double u = (dMatrixOfU/dMatrixOfUV);
			double v = (dMatrixOfV/dMatrixOfUV);
			double [] uvArray = {u,v};
			return uvArray;
		}
	}
	public double determinant(double matrix[][]) {
		double d = ((matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]));
		return d;
	}
	

}
