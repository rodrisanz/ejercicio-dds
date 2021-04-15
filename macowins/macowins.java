public class Prenda{
    private TipoPrenda tipoPrenda;
    private Estado estado;
    private BigDecimal precioBase;

    Prenda(TipoPrenda tipo, Estado estado, BigDecimal precioBase){
        this.tipoPrenda = tipo;
        this.estado = estado;
        this.precioBase = precioBase;
    }

    public BigDecimal calcularPrecioVenta(){
        return tipoPrenda.calcularPrecioVenta(precioBase);
    }
}

public enum TipoPrenda{
    SACO,
    PANTALON,
    CAMISA
}

public interface Estado{
    public BigDecimal calcularPrecioVenta(BigDecimal precio);
}

public class Nueva implements Estado{
    public BigDecimal calcularPrecioVenta(BigDecimal precio){
        return precio;
    }
}

public class Promocion implements Estado{

    BigDecimal valorFijo;

    public BigDecimal calcularPrecioVenta(BigDecimal precio){
        return precio - valorFijo;
    }
}

public class Liquidacion implements Estado{
    public BigDecimal calcularPrecioVenta(BigDecimal precio){
        return precio * 0,5;
    }
}

public class Venta{
    List<Prenda> prendas;
    DateTime fecha;
    TipoPago tipoPago;

    public BigDecimal calcularPrecioBaseTotal(){
        return prendas.sum({prenda => prenda.calcularPrecioVenta()});
    }

    public Int obtenerCantidadPrendas(){
        return prendas.length()
    }

    public List<Prenda> obtenerPrendas(){
        return prendas;
    }

    public BigDecimal calcularPrecioVenta(){
        return tipoPago.calcularRecargo(this):
    }

}

public class Efectivo{
    public BigDecimal calcularRecargo(Venta venta){
        return venta.calcularPrecioBaseTotal();
    }
}

public class Tarjeta extends Efectivo{

    BigDecimal coeficiente;
    Int cuotas;

    @Override
    public BigDecimal calcularRecargo(Venta venta){
        return super.calcularRecargo(venta) + cuotas * coeficiente + (venta.obtenerPrendas().sum({prenda => prenda.calcularPrecioVenta() * 0,01}));
    }
}

public class RepositorioVentas{

    List<Venta> ventas;

    public BigDecimal calcularGananciaPorDia(DateTime dia){
        return ventas.stream().filter({venta => venta.fecha() == dia}).sum({venta => venta.calcularPrecioVenta()});
    }
}