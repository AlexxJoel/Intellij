package operaciones.operaciones.model;

public class BeanOperation {
    private int id;
    private String operation;
    private double data;
    private double result;

    public BeanOperation() {
    }

    public BeanOperation(int id, String operation, double data, double result) {
        this.id = id;
        this.operation = operation;
        this.data = data;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "BeanOperation{" +
                "id=" + id +
                ", operation='" + operation + '\'' +
                ", data=" + data +
                ", result=" + result +
                '}';
    }
}
