package Atividade2.Figura;

public class Cilindro extends Circulo{
  private int altura;

  Cilindro() {
    setAltura(0);
  }

  Cilindro(int a, int b, double r, int h) {
    super(a, b, r);
    setAltura(h);
  }

  public void setAltura(int h) {
    altura = h;
  }

  public int getAltura() {
    return altura;
  }

  public double volume() {
    double v;
    v = super.area() * altura;
    return v;
  }

  public double area() {
    double a;
    a = 2 * super.area() + 2 * Math.PI * super.getRaio() * altura;
    return a;
  }

  public String toString() {
    String res;
    res = "Cilindro : Centro " + super.toString() + "Raio " + super.getRaio() + "Altura " + altura + "Volume " + volume() + "Area " + area();
    return res;
  }

}
