package br.ufes.inf.jfgcalenzani.owid;

public class BirthRecord implements Comparable<BirthRecord>{
    String entity;
    String code;
    Integer year;
    Float lifeExpectMale;
    Float lifeExpectFemale;
    
    public BirthRecord(String entity, String code, Integer year, Float lifeExpectMale, Float lifeExpectFemale) {
        this.entity = entity;
        this.code = code;
        this.year = year;
        this.lifeExpectMale = lifeExpectMale;
        this.lifeExpectFemale = lifeExpectFemale;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getLifeExpectMale() {
        return lifeExpectMale;
    }

    public void setLifeExpectMale(Float lifeExpectMale) {
        this.lifeExpectMale = lifeExpectMale;
    }

    public Float getLifeExpectFemale() {
        return lifeExpectFemale;
    }

    public void setLifeExpectFemale(Float lifeExpectFemale) {
        this.lifeExpectFemale = lifeExpectFemale;
    }

    @Override
    public int compareTo(BirthRecord r2) {
        return -Float.compare(this.getLifeExpectFemale() + this.getLifeExpectMale(), r2.getLifeExpectFemale() + r2.getLifeExpectMale());
    }

    @Override
    public String toString() {
        return "BirthRecord [code=" + code + ", entity=" + entity + ", lifeExpectFemale=" + lifeExpectFemale
                + ", lifeExpectMale=" + lifeExpectMale + ", year=" + year + "]";
    }

  
}
