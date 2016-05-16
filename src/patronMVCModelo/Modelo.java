package patronMVCModelo;

public class Modelo {

    public String realizaOperacion(String op1, String op2, String op) {
        Double aux1, aux2, res;
        aux1 = Double.parseDouble(op1);
        aux2 = Double.parseDouble(op2);

        if (op.equals("+")) {
            res = aux1 + aux2;
        } else {
            res = aux1 - aux2;
        }
        return res.toString();
    }
}
