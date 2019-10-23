package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double t1, t2;
    private boolean prip1, prip2;

    Interval (double t1, double t2, boolean p1, boolean p2){

        if(t1 > t2) throw new IllegalArgumentException("Pocetna tacka veca od krajnje!");
        this.t1 = t1;
        this.t2 = t2;
        prip1 = p1;
        prip2 = p2;

    }

    Interval () {
        t1 = 0; t2 = 0;
        prip1 = false; prip2 = false;
    }



    boolean isNull (){
        if(t1 == 0 && t2 == 0 && prip1 == false && prip2 == false) return true;
        return false;
    }

    boolean isIn (double tacka){

        if(tacka == t1 && prip1 == true) return true;
        else if ( tacka == t2 && prip2 == true) return true;
        else if(tacka > t1 && tacka < t2) return true;

        return false;

    }

    Interval intersect (Interval i){

    //    if(tac1 > t2 || tac2 < t1) return new Interval ();

         if (t2 == i.t1 && i.t2 > t1) return new Interval(t2, t2, true, true);
        else if (t1 == i.t2 && i.t1 < t1) return new Interval(t1, t1, true, true);
        else if (t1 == i.t1 && t2 == i.t2) return new Interval (t1, t2, true, true);
        else if (i.t1 > t1 && i.t1 < t2 && i.t2 > t2) return new Interval (i.t1, t2, i.prip1, prip2);
        else if ( i.t2 > t1 && i.t2 < t2 && i.t1 < t1 ) return new Interval (t1, i.t2, prip1, i.prip2);
        else if ( i.t1 < t1 && i.t2 > t2) return new Interval ( t1, t2, prip1, prip2);
        else if ( t1 < i.t1 && t2 > i.t2) return new Interval (i.t1, i.t2, i.prip1, i.prip2);
        else return new Interval ();
    }

    static Interval intersect (Interval i1, Interval i2){

        //    if(tac1 > t2 || tac2 < t1) return new Interval ();

        if (i1.t2 == i2.t1 && i2.t2 > i1.t1) return new Interval(i1.t2, i1.t2, true, true);
        else if (i1.t1 == i2.t2 && i2.t1 < i1.t1) return new Interval(i1.t1, i1.t1, true, true);
        else if (i1.t1 == i2.t1 && i1.t2 == i2.t2) return new Interval (i1.t1, i1.t2, true, true);
        else if (i2.t1 > i1.t1 && i2.t1 < i1.t2 && i2.t2 > i1.t2) return new Interval (i2.t1, i1.t2, i2.prip1, i1.prip2);
        else if ( i2.t2 > i1.t1 && i2.t2 < i1.t2 && i2.t1 < i1.t1 ) return new Interval (i1.t1, i2.t2, i1.prip1, i2.prip2);
        else if ( i2.t1 < i1.t1 && i2.t2 > i1.t2) return new Interval ( i1.t1, i1.t2, i1.prip1, i1.prip2);
        else if ( i1.t1 < i2.t1 && i1.t2 > i2.t2) return new Interval (i2.t1, i2.t2, i2.prip1, i2.prip2);
        else return new Interval ();
    }

    @Override
    public String toString (){

        if(this.isNull()) return "()";

        String s = new String ();
        if( prip1 == true) s += "[";
        else s += "(";
         s += t1;
         s += ",";
         s += t2;

        if( prip2 == true) s += "]";
        else s += ")";

        return s;
    }

    @Override
    public boolean equals( Object o){
        Interval i = (Interval) o;

        if(t1 == i.t1 && t2 == i.t2 && prip1 == i.prip1 && prip2 == i.prip2) return true;
        return false;

    }


}
