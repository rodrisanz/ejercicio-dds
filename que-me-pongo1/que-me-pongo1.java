public class Prenda{
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrimario;
    Color colorSecundario;

    Prenda(Material material, Color  colorPrimario, TipoPrenda tipoPrenda, Color colorSecundario){
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.tipoPrenda = tipoPrenda;
        this.colorSecundario = colorSecundario;
    }

}

public class TipoPrenda{
    Categoria categoria;

    TipoPrenda(Categoria categoria){
        this.categoria = categoria;
    }
}

public class Color{
    int rojo;
    int verde;
    int azul;

    Color(int rojo, int verde, int azul){
        this.rojo = rojo;
        this.verde = verde;
        this.azul = azul;
    }
}

public enum Material{
    ....
}

public enum Categoria{
    PARTE_SUPERIOR,
    CALZADO,
    PARTE_INFERIOR,
    ACCESORIOS
}