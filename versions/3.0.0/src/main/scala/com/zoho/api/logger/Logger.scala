package com.zoho.api.logger

/**
 * This object represents the Logger level and log file path.
 */
object Logger {
  class Builder() {
    private var level: Levels.Levels = _
    private var filePath: String = _

    def level(level: Levels.Levels): Logger.Builder = {
      this.level = level
      this
    }

    def filePath(filePath: String): Logger.Builder = {
      this.filePath = filePath
      this
    }

    /**
     * Creates an Logger class instance with the specified log level and file path.
     *
     * @return A Logger class instance.
     */
    def build: Logger = new Logger(level, filePath): Logger
  }

  /**
   * This enum contains logger levels.
   */
  object Levels extends Enumeration {
    type Levels = Value
    val OFF, TRACE, DEBUG, INFO, WARN, ERROR, FATAL = Value
  }
}

class Logger protected(levels: com.zoho.api.logger.Logger.Levels.Levels, private var filePath: String) {
  private val level: String = levels.toString

  /**
   * This is a getter method to get logger level.
   *
   * @return A String representing the logger level.
   */
  def getLevel: String = this.level

  /**
   * This is a getter method to get log file path.
   *
   * @return A String representing the log file path.
   */
  def getFilePath: String = this.filePath
}
