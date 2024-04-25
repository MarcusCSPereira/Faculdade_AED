package Atividade2v1;

public class Complexo {

  private double real, imag;
  
  Complexo() {
    setReal(0.0);
    setImag(0.0);
  }

  Complexo(double r, double i) {
    setReal(r);
    setImag(i);
  }

  public void setReal(double r) {
    real = r;
  }
  public void setImag(double i) {
    imag = i;
  }

  public double getReal() {
    return real;
  }

  public double getImag() {
    return imag;
  }

  public Complexo soma(Complexo c) {
    Complexo res = new Complexo();
    res.setReal(real + c.getReal());
    res.setImag(imag + c.getImag());
    return res;
  }

  public Complexo subtrai(Complexo c) {
    Complexo res = new Complexo();
    res.setReal(real - c.getReal());
    res.setImag(imag - c.getImag());
    return res;
  }

  @Override
  public String toString() {
    String res;
    res = "Complexo: Real " + real + " Imaginario " + imag;
    return res;
  }
}
