package com.fact.mycls

//自定义有理数
class MyRational( n : Int,  d : Int) extends{
  override protected val myval : Int = d
} with RationalTrait{
  //分母不为0
  require(d != 0)
  //公有因子
  protected val g : Int = gcd(n.abs, d.abs)
  //自定义字段，懒加载lazy，只有调用的时候才会加载/初始化
  lazy protected val number : Int = n / g
  lazy protected val demon : Int = d / g


  //自定义构造函数
  def this(n : Int) = this(n, 1)

  //无法访问n和d
//  def add(that : MyRational) : MyRational = {
//    new MyRational(n * that.d + that.n * d, d * that.d)
//  }
  def add(that : MyRational) : MyRational = {
    new MyRational(this.number * that.demon + that.number * this.demon, this.demon * that.demon)
  }

  //自定义操作符
  def +(that : MyRational) : MyRational = {
    new MyRational(this.number * that.demon + that.number * this.demon, this.demon * that.demon)
  }

  def -(that : MyRational) : MyRational =
    new MyRational(this.number * that.demon - that.number * this.demon, this.demon * that.demon)

  def *(that : MyRational) : MyRational = {
    new MyRational(this.number * that.number, this.demon * that.demon)
  }

  def /(that : MyRational) : MyRational =
    new MyRational(this.number * that.demon, this.demon * that.number)

  //定义与整数运算
  def +(i : Int) : MyRational =
    new MyRational(this.number  + i * this.demon, this.demon)

  def -(i : Int) : MyRational =
    new MyRational(this.number  - i * this.demon, this.demon)

  def *(i : Int) : MyRational =
    new MyRational(this.number * i, this.demon )

  def /(i : Int) : MyRational =
    new MyRational(this.number , this.demon * i)

  //此处不能定义隐式转换，把操作符前面的整数自动转换成MyRational
//  implicit def intToMyRational(x : Int) : MyRational = new MyRational(x)

  def gcd(a : Int, b :Int) : Int = {
    if(b == 0) a else gcd(b, a % b)
  }
  //自定义toString
  override def toString: String = {
    this.number + "/" + this.demon
  }
}

object MyRational{
  //定义隐式转换，把操作符前面的整数自动转换成MyRational
  implicit def intToMyRational(x : Int) : MyRational = new MyRational(x)
}