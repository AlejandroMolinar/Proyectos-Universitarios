package Farmacia;

public class Medicamentos { 
	private int codigo;
	private	String nombre;
	private String descripcionMed;
	private String laboratorio;
	private String proveedor;
	private double precio;
	private int IVA;
	private int stock;
	private int fechaDD;
	private int fechaMM;
	private int fechaYY;
	
//---------------------------Getter y Setter-------------------------------------------------------------------------	
	
	public Medicamentos(int codigo, String nombre, String descripcionMed, String laboratorio, String proveedor,
			double precio, int iVA, int stock, int fechaDD, int fechaMM, int fechaYY) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcionMed = descripcionMed;
		this.laboratorio = laboratorio;
		this.proveedor = proveedor;
		this.precio = precio;
		IVA = iVA;
		this.stock = stock;
		this.fechaDD = fechaDD;
		this.fechaMM = fechaMM;
		this.fechaYY = fechaYY;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcionMed() {
		return descripcionMed;
	}
	public void setDescripcionMed(String descripcionMed) {
		this.descripcionMed = descripcionMed;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIVA() {
		return IVA;
	}
	public void setIVA(int iVA) {
		IVA = iVA;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getFechaDD() {
		return fechaDD;
	}
	public void setFechaDD(int fechaDD) {
		this.fechaDD = fechaDD;
	}
	public int getFechaMM() {
		return fechaMM;
	}
	public void setFechaMM(int fechaMM) {
		this.fechaMM = fechaMM;
	}
	public int getFechaYY() {
		return fechaYY;
	}
	public void setFechaYY(int fechaYY) {
		this.fechaYY = fechaYY;
	}

//---------------------------Getter y Setter-------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Medicamentos\n-codigo = " + codigo + "\n-nombre = " + nombre + "\n-descripcionMed = " + descripcionMed
				+ "\n-laboratorio = " + laboratorio + "\n-proveedor = " + proveedor + "\n-precio = " + precio + "\n-IVA = " + IVA
				+ "\n-stock = " + stock + "\n-fecha = " + fechaDD + "/" + fechaMM + "/" + fechaYY + "\n\n";
	}	
	

	
	
	
	
	
}
