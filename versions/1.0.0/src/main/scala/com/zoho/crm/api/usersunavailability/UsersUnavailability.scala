package com.zoho.crm.api.usersunavailability

import com.zoho.crm.api.util.Model
import java.time.OffsetDateTime
import scala.collection.mutable.HashMap

class UsersUnavailability extends Model	{
	private var service:Option[String] = None
	private var title:Option[String] = None
	private var allDay:Option[Boolean] = None
	private var tpCalendarId:Option[String] = None
	private var tpEventId:Option[String] = None
	private var comments:Option[String] = None
	private var from:Option[OffsetDateTime] = None
	private var id:Option[Long] = None
	private var to:Option[OffsetDateTime] = None
	private var user:Option[User] = None
	private var keyModified:HashMap[String, Int] = HashMap()

	def getService() :Option[String]	={
		return  this.service
	}

	def setService( service: Option[String]) 	={
		 this.service = service
		 this.keyModified("service") = 1
	}

	def getTitle() :Option[String]	={
		return  this.title
	}

	def setTitle( title: Option[String]) 	={
		 this.title = title
		 this.keyModified("title") = 1
	}

	def getAllDay() :Option[Boolean]	={
		return  this.allDay
	}

	def setAllDay( allDay: Option[Boolean]) 	={
		 this.allDay = allDay
		 this.keyModified("all_day") = 1
	}

	def getTpCalendarId() :Option[String]	={
		return  this.tpCalendarId
	}

	def setTpCalendarId( tpCalendarId: Option[String]) 	={
		 this.tpCalendarId = tpCalendarId
		 this.keyModified("tp_calendar_id") = 1
	}

	def getTpEventId() :Option[String]	={
		return  this.tpEventId
	}

	def setTpEventId( tpEventId: Option[String]) 	={
		 this.tpEventId = tpEventId
		 this.keyModified("tp_event_id") = 1
	}

	def getComments() :Option[String]	={
		return  this.comments
	}

	def setComments( comments: Option[String]) 	={
		 this.comments = comments
		 this.keyModified("comments") = 1
	}

	def getFrom() :Option[OffsetDateTime]	={
		return  this.from
	}

	def setFrom( from: Option[OffsetDateTime]) 	={
		 this.from = from
		 this.keyModified("from") = 1
	}

	def getId() :Option[Long]	={
		return  this.id
	}

	def setId( id: Option[Long]) 	={
		 this.id = id
		 this.keyModified("id") = 1
	}

	def getTo() :Option[OffsetDateTime]	={
		return  this.to
	}

	def setTo( to: Option[OffsetDateTime]) 	={
		 this.to = to
		 this.keyModified("to") = 1
	}

	def getUser() :Option[User]	={
		return  this.user
	}

	def setUser( user: Option[User]) 	={
		 this.user = user
		 this.keyModified("user") = 1
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