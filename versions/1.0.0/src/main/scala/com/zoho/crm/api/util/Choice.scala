package com.zoho.crm.api.util

class Choice[T] {
  var value: T = _

  def this(value: T) {
    this()
    this.value = value
  }

  def getValue: T = {
    this.value
  }
}