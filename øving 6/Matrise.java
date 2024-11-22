public class Matrise {
    private final int[][] matrix; //immutable

    public Matrise (int[][] matrix) {
        this.matrix = new int[matrix.length][matrix[0].length]; //matrix[0].length return numbers of columns in first row
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    //Addition
    public Matrise add(Matrise other){
        if (this.matrix.length != other.matrix.length || this.matrix[0].length != other.matrix[0].length) {
            return null;
        }

        int[][] result = new int[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++){
            for (int j = 0; j < this.matrix[0].length; j++){
                result[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrise(result);
    }

    //Multiplication
    public Matrise multiply(Matrise other) {
        if (this.matrix[0].length != other.matrix.length) {
            return null;
        }

        int[][] result = new int[this.matrix.length][other.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++){
            for (int j = 0; j < other.matrix[0].length; j++){
                for (int k = 0; k < this.matrix[0].length; k++){ //go through each columns
                    result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrise(result);
    }

    //Tranpose
    public Matrise transpose() {
        int[][] result = new int[this.matrix[0].length][this.matrix.length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result[j][i] = this.matrix[i][j];
            }
        }
        return new Matrise(result);
    }

    public void print() {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Eksempelmatriser
        int[][] data1 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] data2 = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        int[][] data3 = {
            {1, 1, 1},
            {1, 1, 1}
        };

        Matrise matrise1 = new Matrise(data1);
        Matrise matrise2 = new Matrise(data2);
        Matrise matrise3 = new Matrise(data3);

        // Addisjon av to matriser
        System.out.println("Addisjon av matrise1 og matrise3:");
        Matrise addResult = matrise1.add(matrise3);
        if (addResult != null) {
            addResult.print();
        } else {
            System.out.println("Kan ikke addere matriser med ulike dimensjoner.");
        }

        // Multiplikasjon av to matriser
        System.out.println("\nMultiplikasjon av matrise1 og matrise2:");
        Matrise multiplyResult = matrise1.multiply(matrise2);
        if (multiplyResult != null) {
            multiplyResult.print();
        } else {
            System.out.println("Kan ikke multiplisere matriser med ugyldige dimensjoner.");
        }

        // Transponere en matrise
        System.out.println("\nTransponering av matrise1:");
        Matrise transposeResult = matrise1.transpose();
        transposeResult.print();
    }
}
