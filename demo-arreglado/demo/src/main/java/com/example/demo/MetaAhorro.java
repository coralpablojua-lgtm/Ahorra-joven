package com.example.demo;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="metas_ahorro")
public class MetaAhorro {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Size(max=100) private String nombre;
 @NotNull @DecimalMin(value="1000.00") @Digits(integer=12,fraction=2) @Column(nullable=false,precision=14,scale=2) private BigDecimal objetivo;
 @NotNull @DecimalMin(value="0.00") @Digits(integer=12,fraction=2) @Column(nullable=false,precision=14,scale=2) private BigDecimal ahorrado=BigDecimal.ZERO;
 @Size(max=300) private String descripcion; private LocalDate fechaObjetivo;
 public MetaAhorro() {}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getNombre(){return nombre;} public void setNombre(String nombre){this.nombre=nombre;}
 public BigDecimal getObjetivo(){return objetivo;} public void setObjetivo(BigDecimal objetivo){this.objetivo=objetivo;}
 public BigDecimal getAhorrado(){return ahorrado;} public void setAhorrado(BigDecimal ahorrado){this.ahorrado=ahorrado;}
 public String getDescripcion(){return descripcion;} public void setDescripcion(String descripcion){this.descripcion=descripcion;}
 public LocalDate getFechaObjetivo(){return fechaObjetivo;} public void setFechaObjetivo(LocalDate fechaObjetivo){this.fechaObjetivo=fechaObjetivo;}
 public int getPorcentaje(){if(objetivo==null||objetivo.signum()<=0)return 0;return ahorrado.multiply(new BigDecimal("100")).divide(objetivo,0,java.math.RoundingMode.HALF_UP).min(new BigDecimal("100")).intValue();}
}
