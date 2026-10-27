package com.example.demo;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="movimientos")
public class Movimiento {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Size(max=120) private String concepto;
 @NotNull @Enumerated(EnumType.STRING) private TipoMovimiento tipo;
 @NotNull @DecimalMin(value="0.01") @Digits(integer=12,fraction=2) @Column(nullable=false,precision=14,scale=2) private BigDecimal valor;
 @NotNull private LocalDate fecha=LocalDate.now();
 private Long metaId;
 public enum TipoMovimiento { INGRESO, GASTO, APORTE }
 public Movimiento() {}
 public Long getId(){return id;} public void setId(Long id){this.id=id;} public String getConcepto(){return concepto;} public void setConcepto(String concepto){this.concepto=concepto;}
 public TipoMovimiento getTipo(){return tipo;} public void setTipo(TipoMovimiento tipo){this.tipo=tipo;} public BigDecimal getValor(){return valor;} public void setValor(BigDecimal valor){this.valor=valor;} public LocalDate getFecha(){return fecha;} public void setFecha(LocalDate fecha){this.fecha=fecha;} public Long getMetaId(){return metaId;} public void setMetaId(Long metaId){this.metaId=metaId;}
}
