面向对象编程
public final class Fruit_2$
{
public static final Fruit_2$ MODULE$;
private String color;

static {
    new Fruit_2$();
}

public String color() {
    return this.color;
}

public void color_$eq(final String x$1) {
    this.color = x$1;
}

private Fruit_2$() {
    MODULE$ = this;
    this.color = "red";
}
}
public class Fruit_2
{
  private String name;

  public static void color_$eq(final String x$1) {
      Fruit_2$.MODULE$.color_$eq(x$1);
  }

  public static String color() {
      return Fruit_2$.MODULE$.color();
  }

  public String name() {
      return this.name;
  }

  public void name_$eq(final String x$1) {
      this.name = x$1;
  }
}


trait 编译 

public class MySql implements DBConnection
{
    @Override
    public void showInfo() {
        DBConnection$class.showInfo(this);
    }
    
    @Override
    public void createConnection() {
        Predef$.MODULE$.println((Object)"create mysql connection...");
    }
    
    @Override
    public boolean close() {
        Predef$.MODULE$.println((Object)"mysql close ...");
        return true;
    }
    
    public MySql() {
        DBConnection$class.$init$(this);
    }
}