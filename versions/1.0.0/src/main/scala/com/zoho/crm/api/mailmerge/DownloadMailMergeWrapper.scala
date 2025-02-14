package com.zoho.crm.api.mailmerge

import com.zoho.crm.api.util.Model
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

class DownloadMailMergeWrapper extends Model	{
	private var downloadMailMerge:ArrayBuffer[DownloadMailMerge] = _
	private var keyModified:HashMap[String, Int] = HashMap()

	def getDownloadMailMerge() :ArrayBuffer[DownloadMailMerge]	={
		return  this.downloadMailMerge
	}

	def setDownloadMailMerge( downloadMailMerge: ArrayBuffer[DownloadMailMerge]) 	={
		 this.downloadMailMerge = downloadMailMerge
		 this.keyModified("download_mail_merge") = 1
	}

	def isKeyModified( key: String) :Any	={
		if((( this.keyModified.contains(key))))
		{
			return  this.keyModified(key)
		}
		return None
	}

	def setKeyModified( key: String,  modification: Int) 	={
		 this.keyModified(key) = modification
	}}