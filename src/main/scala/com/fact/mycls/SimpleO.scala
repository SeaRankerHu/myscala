package com.fact.mycls

class SimpleO {

  private[this] var _name : String = _
  private[this] var _sex : String = _

  //定义get和set方法
  def name : String = this._name
  def name_=(name : String) : Unit = this._name = name

  def sex = this._sex
  def sex_=(sex : String) : Unit = this._sex = sex


}
