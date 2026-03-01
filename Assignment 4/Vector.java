public class Vector {
    private double[] arr;
    public Vector(double[] arr) throws VectorException {
        if (arr == null) {
            throw new VectorException("Array is null.");
        }
        if (arr.length != 2 && arr.length != 3) {
            throw new VectorException("Vector should be 2D or 3D.");
        }
        this.arr = arr;
    }
    public Vector add(Vector v1) throws VectorException {
        if (this.arr.length != v1.arr.length) {
            throw new VectorException("Vectors must have same dimension");
        }
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = this.arr[i] + v1.arr[i];
        }
        return new Vector(result);
    }
    public Vector subtract(Vector v1) throws VectorException {
        if (this.arr.length != v1.arr.length) {
            throw new VectorException("Vectors must have same dimension");
        }
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = this.arr[i] - v1.arr[i];
        }
        return new Vector(result);
    }
    public double dotProduct(Vector v1) throws VectorException {
        if (this.arr.length != v1.arr.length) {
            throw new VectorException("Vectors must have same dimension");
        }
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += this.arr[i] * v1.arr[i];
        }
        return sum;
    }
    public void printVector(Vector v1) {
        for (double value : v1.arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
