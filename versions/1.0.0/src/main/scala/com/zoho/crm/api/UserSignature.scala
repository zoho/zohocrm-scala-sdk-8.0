package com.zoho.crm.api

import com.zoho.crm.api.util.{Constants, Utility}

class UserSignature(var name: String){
  Utility.assertNotNull(name, Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR.concat(" - ").concat(Constants.NAME))

  def getName: String = name
}