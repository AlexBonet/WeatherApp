package com.dam.proyectodamdaw.Recycler;

import com.dam.proyectodamdaw.base.ImageDownloader;

public class WeatherOne {
    private String imagen;
    private String dia;
    private String hora;
    private String fecha;
    private String descripcion;
    private String gradosTemp;
    private String gradosMax;
    private String gradosMin;
    private String humedad;
    private String sensacionTermica;

    public WeatherOne(String imagen, String dia, String hora, String fecha, String descripcion, String gradosTemp, String gradosMax, String gradosMin, String humedad, String sensacionTermica) {
        this.imagen = imagen;
        this.dia = dia;
        this.hora = hora;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.gradosTemp = gradosTemp;
        this.gradosMax = gradosMax;
        this.gradosMin = gradosMin;
        this.humedad = humedad;
        this.sensacionTermica = sensacionTermica;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGradosTemp() {
        return gradosTemp;
    }

    public String getGradosMax() {
        return gradosMax;
    }

    public String getGradosMin() {
        return gradosMin;
    }

    public String getHumedad() {
        return humedad;
    }

    public String getSensacionTermica() {
        return sensacionTermica;
    }
}
