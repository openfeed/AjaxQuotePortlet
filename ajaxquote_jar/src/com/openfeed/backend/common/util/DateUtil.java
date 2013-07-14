package com.openfeed.backend.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

import org.apache.log4j.Logger;

/**
 * Utilities to manipulate dates, including add days, subtract days, and date
 * formatting/parsing.
 * 
 * @version 1.0
 * @author ouellec
 * 
 *         Modification History Date Author Comments 09/08/2005 C. Ouellette
 *         Original
 */
public class DateUtil {
	private static Logger log = Logger.getLogger(DateUtil.class);

	public static Date MIN_DATE = getMinDate();
	public static Date MAX_DATE = getMaxDate();

	private static SimpleDateFormat stdFormatter = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");
	private static SimpleDateFormat isoFormatter = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static SimpleDateFormat SQLDateFormatter = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss.SSS");
	private static SimpleDateFormat iso8601Formatter = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssZ");

	public static final String MMDDYYYY_FORMAT = "MM/dd/yyyy";
	public static final String YYYY_MM_DD_FORMAT = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_HH_MM_SS_SSS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String HH_MM_SS_SSS_FORMAT = "HH:mm:ss.SSS";
	public static final String AM = "AM";
	public static final String PM = "PM";

	/**
	 * Default constructor
	 */
	public DateUtil() {

	}

	/**
	 * Parse a date string which is in the format of "yyyyMMddHHmmssSSS" into a
	 * java.util.Date object.
	 * 
	 * @param val
	 *            The date string to parse
	 * @return date The parsed Date
	 */
	public static Date parse(String val) throws java.text.ParseException {
		if (val == null || val.trim().length() == 0)
			return null;
		return stdFormatter.parse(val);
	}

	/**
	 * Parse a String val based on the string format provided.
	 * 
	 * @param format
	 *            The SimpleDateFormat string
	 * @param val
	 *            The date string to parse
	 * 
	 * @return date The parsed Date
	 */
	public static Date parse(String format, String val)
			throws java.text.ParseException {
		if (val == null || val.trim().length() == 0)
			return null;
		validateDate(val, format);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setLenient(false);
		return formatter.parse(val);
	}

	private static void validateDate(String val, String format)
			throws ParseException {
		if (format.equals("MM/dd/yyyy")) {
			StringTokenizer strt = new StringTokenizer(val, "/");
			if (strt.countTokens() != 3) {
				throw new ParseException("Incorrect date format", 0);
			} else {
				try {
					int month = Integer.parseInt(strt.nextToken());
					int day = Integer.parseInt(strt.nextToken());
					int year = Integer.parseInt(strt.nextToken());
					if (month < 1 || month > 12 || day < 1 || day > 31
							|| year > 3000 || year < 1000) {
						throw new ParseException("Incorrect date format", 0);
					}
				} catch (NumberFormatException e) {
					throw new ParseException("Incorrect date format", 0);
				}
			}
		}
	}

	/**
	 * Parse a String val based on the string format and timezone provided.
	 * 
	 * @param format
	 *            The SimpleDateFormat string
	 * @param val
	 *            The date string to parse
	 * @param timezone
	 *            The timezone
	 * 
	 * @return date The parsed Date
	 */
	public static Date parse(String format, String val, String timezone)
			throws java.text.ParseException {
		if (val == null || val.trim().length() == 0)
			return null;
		TimeZone tz = null;
		if (timezone == null || timezone.length() == 0) {
			tz = TimeZone.getDefault();
		} else {
			tz = TimeZone.getTimeZone(timezone);
		}
		return parse(format, val, tz);
	}

	/**
	 * This private parse method is called by the public parse method that
	 * accepts a timezone.
	 * 
	 * @param format
	 *            The SimpleDateFormat string
	 * @param val
	 *            The date string to parse
	 * @param timezone
	 *            The timezone
	 * 
	 * @return date The parsed Date
	 */
	private static Date parse(String format, String val, TimeZone timezone)
			throws java.text.ParseException {
		if (val == null || val.trim().length() == 0)
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setTimeZone(timezone);
		formatter.setLenient(false);
		return formatter.parse(val);
	}

	/**
	 * Format a Date into a string with the format of "yyyyMMddHHmmssSSS".
	 * 
	 * @param val
	 *            The Date to format
	 * 
	 * @return dstr The formatted date string
	 */
	public static String format(Date val) {
		if (val == null)
			return null;
		return stdFormatter.format(val);
	}

	/**
	 * Format a Date into a string with the format of the format argument.
	 * 
	 * @param format
	 *            The SimpleDateFormat string
	 * @param val
	 *            The Date to format
	 * 
	 * @return dstr The formatted date string
	 */
	public static String format(String format, Date val) {
		if (val == null)
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setLenient(false);
		return formatter.format(val);
	}

	/**
	 * Parses a date string in MSSQL server standard
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseMSSQLDate(String date) {
		Date m_date = null;
		try {
			m_date = parse("yyyy-MM-dd HH:mm:ss.SSS", date);
		} catch (ParseException e) {
			// ignore
			e.printStackTrace();
		}
		return m_date;
	}

	/**
	 * Formats date to MS SQL server standard Returns date as formatted string
	 * 
	 * @param val
	 * @return
	 */
	public static String formatMSSQLDate(Date val) {
		if (val == null)
			return null;
		SQLDateFormatter.setLenient(false);
		return SQLDateFormatter.format(val);
	}

	/**
	 * Formats date to ISO8601 server standard Returns date as formatted string
	 * 
	 * @param val
	 * @return
	 */
	public static String formatISO8601Date(Date val) {
		if (val == null)
			return null;
		iso8601Formatter.setLenient(false);
		String dtStr = iso8601Formatter.format(val);
		return dtStr.substring(0, dtStr.length() - 2) + ":"
				+ dtStr.substring(dtStr.length() - 2);
	}

	public static String format(String format, Date val, Locale locale) {
		if (val == null)
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat(format, locale);
		formatter.setLenient(false);
		return formatter.format(val);
	}

	/**
	 * Format a Date into a string with the format of the format argument for
	 * the given timezone.
	 * 
	 * @param format
	 *            The SimpleDateFormat string
	 * @param val
	 *            The Date to format
	 * @param timezone
	 *            The timezone
	 * 
	 * @return dstr The formatted date string
	 */
	public static String format(String format, Date val, String timezone) {
		if (val == null)
			return null;
		TimeZone tz = null;
		if (timezone == null || timezone.length() == 0) {
			tz = TimeZone.getDefault();
		} else {
			tz = TimeZone.getTimeZone(timezone);
		}
		return format(format, val, tz);
	}

	/**
	 * This private format method is called by the public format method that
	 * accepts a timezone.
	 * 
	 * @param format
	 *            The SimpleDateFormat string
	 * @param val
	 *            The Date to format
	 * @param timezone
	 *            The timezone
	 * 
	 * @return dstr The formatted date string
	 */
	private static String format(String format, Date val, TimeZone timezone) {
		if (val == null)
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setTimeZone(timezone);
		formatter.setLenient(false);
		return formatter.format(val);
	}

	/**
	 * Check whether a date is Saturday
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return boolean true if Saturday, else false
	 */
	public static boolean isSaturday(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int day = cal.get(Calendar.DAY_OF_WEEK);

		return (day == Calendar.SATURDAY) ? true : false;
	}

	/**
	 * Check whether a date is Sunday
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return boolean true if Sunday, else false
	 */
	public static boolean isSunday(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int day = cal.get(Calendar.DAY_OF_WEEK);

		return (day == Calendar.SUNDAY) ? true : false;
	}

	/**
	 * Check whether a date is a weekend
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return boolean true if weekend, else false
	 */
	public static boolean isWeekend(Date dt) {
		return isSaturday(dt) || isSunday(dt);
	}

	/**
	 * Get and return the day of week from the given Date dt
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return day The abbreviated String value of the day
	 */
	public static String getDayOfWeek(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		switch (dow) {
		case 1:
			return "SUN";
		case 2:
			return "MON";
		case 3:
			return "TUE";
		case 4:
			return "WED";
		case 5:
			return "THU";
		case 6:
			return "FRI";
		case 7:
			return "SAT";
		default:
			return "";
		}
	}

	public static Date getDate(short year, short month, short day, short hour,
			short minute, short second, int millisends) {
		Calendar cal = new GregorianCalendar();
		cal.set(year, month, day, hour, minute, second);
		cal.set(Calendar.MILLISECOND, millisends);
		return cal.getTime();
	}

	/**
	 * Get and return the day of week int value from the given Date dt
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return day int value of day of week
	 */
	public static int getDOW(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return (cal.get(Calendar.DAY_OF_WEEK));
	}

	/**
	 * Get and return the hour of the day from the given Date dt
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return day The int value for hour of day
	 */
	public static int getHourOfDay(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return (cal.get(Calendar.HOUR_OF_DAY));
	}

	/**
	 * Returns an hour in AM
	 * 
	 * @param dt
	 * @return
	 */
	public static int getHourOfDayInAm(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour > 12) {
			hour = hour - 12;
		}
		return hour;
	}

	/**
	 * Returns Seconds of the date
	 * 
	 * @param dt
	 *            The given Date
	 * @return int
	 */
	public static int getSeconds(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.SECOND);
	}

	/**
	 * Method returns a difference in mlseconds between two dates
	 * 
	 * @param greater
	 * @param lesser
	 * @return
	 */
	public static long getDifference(Date greater, Date lesser) {
		long greaterSec = greater.getTime();
		long lesserSec = lesser.getTime();
		return (greaterSec - lesserSec);
	}

	/**
	 * Return next monday
	 * 
	 * @param dt
	 * @return
	 */
	public static Date nextMonday(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		int days = cal.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY;
		if (days < 0) {
			cal.add(Calendar.DATE, (-days));
		} else {
			cal.add(Calendar.DATE, (7 - days));
		}
		return cal.getTime();
	}

	/**
	 * Get and return the minutes of the hour from the given Date dt
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return day The int value for minutes of hour
	 */
	public static int getMinutesOfHour(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return (cal.get(Calendar.MINUTE));
	}

	/**
	 * Get and return the hours and minutes from the given Date dt, ex: 11:30
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return hrsMin The hours and minutes of date in format hh:mm
	 */
	public static String getHourAndMinutes(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return (cal.get(Calendar.HOUR) + ":" + (cal.get(Calendar.MINUTE)));
	}

	/**
	 * Get and return AM or PM from the given Date dt
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return int value of AM or PM
	 */
	public static int getAmPm(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return (cal.get(Calendar.AM_PM));
	}

	/**
	 * Returns a string representation of AM or PM values
	 * 
	 * @param dt
	 * @return
	 */
	public static String getAmPmAsString(Date dt) {
		String returnValue = AM;
		if (getAmPm(dt) == 0) {
			returnValue = AM;
		} else {
			returnValue = PM;
		}
		return returnValue;
	}

	/**
	 * Get and return the day of month from the given Date dt
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return day The int value for day of month
	 */
	public static int getDayOfMonth(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return (cal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * Get and return the month of year from the given Date dt
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return day The int value for month of year
	 */
	public static int getMonthOfYear(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return (cal.get(Calendar.MONTH));
	}

	/**
	 * Get and return the year from the given Date dt
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return day The int value for year
	 */
	public static int getYear(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return (cal.get(Calendar.YEAR));
	}

	/**
	 * Set a Date dt to the start of the day, with the hour, minute, second and
	 * millisecods all zeros(AM). This could be used for possible scheduling.
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return date The day end Date for the given date
	 */
	public static Date dayStart(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.get(Calendar.HOUR_OF_DAY);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);

		return cal.getTime();
	}

	/**
	 * Set a Date dt to the end of the day, that is, 11:59:59:999pm return the
	 * new Date. This could be used for possible scheduling
	 * 
	 * @param dt
	 *            The given Date
	 * 
	 * @return date The day end Date for the given date
	 */
	public static Date dayEnd(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);

		return cal.getTime();
	}

	/**
	 * Add number of days to current Date and return the new Date.
	 * 
	 * @param dt
	 *            The given date
	 * @param days
	 *            The number of days to add
	 * 
	 * @return date The new Date
	 */
	public static Date addDays(Date dt, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	/**
	 * Add number of months to current Date and return the new Date.
	 * 
	 * @param dt
	 *            The given date
	 * @param mons
	 *            The number of months to add
	 * 
	 * @return date The new Date
	 */
	public static Date addMonths(Date dt, int mons) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.MONTH, mons);
		return cal.getTime();
	}

	/**
	 * Add number of years to current Date and return the new Date.
	 * 
	 * @param dt
	 *            The given date
	 * @param days
	 *            The number of days to add
	 * 
	 * @return date The new Date
	 */
	public static Date addYears(Date dt, int years) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.YEAR, years);

		return cal.getTime();
	}

	/**
	 * Similar to addDays. Given a Date and # of days (param days should <= 0),
	 * return the new Date that is # of days prior to dt.
	 * 
	 * @param dt
	 *            The given date
	 * @param days
	 *            The number of months to add
	 * 
	 * @return date The new Date
	 */
	public static Date getFullDaysPrior(Date dt, int days) {
		days = (days <= 0) ? days : 0;
		return addDays(dayStart(dt), days);
	}

	/**
	 * Similar to addDays. Given a Date and # of days (param days should >= 0),
	 * return the new Date that is # of days ahead of dt.
	 * 
	 * @param dt
	 *            The given date
	 * @param days
	 *            The number of months to add
	 * 
	 * @return date The new Date
	 */
	public static Date getFullDaysAhead(Date dt, int days) {
		days = (days >= 0) ? days : 0;
		return addDays(dayEnd(dt), days);
	}

	/**
	 * Get todays date
	 * 
	 * @return date Todays Date
	 */
	public static Date getToday() {
		return new Date();
	}

	/**
	 * get todays date, format and parse to set hh:mm:ss to 12:00:00 and return,
	 * used in date comparison logic
	 * 
	 * @return date Todays Date at 12:00:00
	 */
	public static Date getTodayAdjusted() {

		Date today = new Date();
		try {
			String temp = format("MM/dd/yyyy", today);
			today = parse("MM/dd/yyyy", temp);
			log.info("\nToday: " + format("MM/dd/yyyy hh:mm:ss", today));
		} catch (ParseException e) {
			return new Date();
		}
		return today;
	}

	/**
	 * Get todays date and format into an ISO date string and return
	 * 
	 * @return dateStr Todays date string in ISO format
	 */
	public static String getISODate() {
		return isoFormatter.format(getToday());
	}

	/**
	 * Format the given Date dt into an ISO date string and return
	 * 
	 * @param dt
	 *            The given date
	 * 
	 * @return dateStr Todays date string in ISO format
	 */
	public static String getISODate(Date dt) {
		return isoFormatter.format(dt);
	}

	/**
	 * Get the YTD start date for the given year of the date provided
	 * 
	 * @param dt
	 *            The given date
	 * @return Date The YTD start date
	 */
	public static Date getYTDStartDate(Date dt) {
		dayStart(dt);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, cal
				.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dayStart(cal.getTime());
	}

	/**
	 * Get the last date for the given year of the date provided
	 * 
	 * @param dt
	 *            The given date
	 * @return Date The last date
	 */
	public static Date getLastDateOfYear(Date dt) {
		dayEnd(dt);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, cal
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dayStart(cal.getTime());
	}

	/**
	 * Test whether the date passed is a month starting date
	 * 
	 * @param dt
	 *            The given value
	 * @return true if first day of month, false otherwise
	 */
	public static boolean isMonthStart(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		if (cal.getActualMinimum(Calendar.DAY_OF_MONTH) == cal
				.get(Calendar.DAY_OF_MONTH)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Test whether the date passed is a month starting date
	 * 
	 * @param dt
	 *            The given value
	 * @return true if first day of month, false otherwise
	 */
	public static boolean isQuarterStart(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		if ((cal.getActualMinimum(Calendar.DAY_OF_MONTH) == cal
				.get(Calendar.DAY_OF_MONTH))
				&& (cal.get(Calendar.MONTH) % 3 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get the last day of the month
	 * 
	 * @param dt
	 *            The given date
	 * @return Date the last day of the month
	 */
	public static Date getLastDayOfMonth(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.DAY_OF_MONTH, cal
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dayEnd(cal.getTime());
	}

	/**
	 * Get the last day of the quarter
	 * 
	 * @param dt
	 *            The given date
	 * @return Date the last day of the month
	 */
	public static Date getLastDayOfQuarter(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, cal
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dayEnd(cal.getTime());
	}

	/**
	 * Constructs a file stamp for a given date yyyyMMdd
	 * 
	 * @param dt
	 * @return the stamp
	 */
	public static String constructFileStamp(Date dt) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(dt);
	}

	/**
	 * Gets the start date for the current full week
	 * 
	 * @param dt
	 * @return the date
	 */
	public static Date getCurrentWeekStartDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.DATE, -(cal.get(Calendar.DAY_OF_WEEK) - cal
				.getFirstDayOfWeek()));
		return dayStart(cal.getTime());
	}

	/**
	 * Gets the start date for the previous full week
	 * 
	 * @param dt
	 * @return the date
	 */
	public static Date getPreviousWeekStartDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.DATE, -8);
		cal.add(Calendar.DATE, -(cal.get(Calendar.DAY_OF_WEEK) - cal
				.getFirstDayOfWeek()));
		return dayStart(cal.getTime());
	}

	/**
	 * Gets the start date for the previous full month
	 * 
	 * @param dt
	 * @return the date
	 */
	public static Date getPreviousMonthStartDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, cal
				.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dayStart(cal.getTime());
	}

	/**
	 * Gets the start date for the previous quarter
	 * 
	 * @param dt
	 * @return the date
	 */
	public static Date getPreviousQuarterStartDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int calMonth = cal.get(Calendar.MONTH);
		int calMonthMod = (calMonth) % 3;
		cal.add(Calendar.MONTH, -(calMonthMod + 3));
		cal.set(Calendar.DAY_OF_MONTH, cal
				.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dayStart(cal.getTime());
	}

	/**
	 * Gets a date from a legacy date in the form of cyyMMdd
	 * 
	 * @param l
	 * @return
	 */
	public static Date parseLegacyDate(long l) {
		Date m_date = null;
		String str = null;
		try {
			if (l == 0) {
				m_date = DateUtil.getDefaultDate();
			} else {
				str = new Long(l).toString();
				if (str.length() == 6) {
					m_date = DateUtil.parse("yyMMdd", str);
				} else {
					m_date = DateUtil.parse("yyMMdd", str.substring(1, 7));
				}
			}
		} catch (ParseException e) {
			// set default date on ParseException
			log.debug("\nparse legacy date ParseException: " + str);
			m_date = DateUtil.getDefaultDate();
		} catch (Exception e) {
			// set default date on Exception
			log.debug("\nparse legacy date Exception: " + str);
			m_date = DateUtil.getDefaultDate();
		}
		return m_date;
	}

	/**
	 * Gets a date from a legacy date in the form of cyyMMdd and time in the
	 * format hhmmss
	 * 
	 * @param legacyDate
	 * @param legacyTime
	 * @return
	 */
	public static Date parseLegacyDateTime(long legacyDate, long legacyTime) {
		Date date = getDefaultDate();
		String legacyDt = DateUtil.format("yyyyMMdd", DateUtil
				.parseLegacyDate(legacyDate));
		try {
			if (String.valueOf(legacyTime).length() == 5) {
				date = stdFormatter.parse(legacyDt + "0"
						+ String.valueOf(legacyTime) + "000");
			} else if (String.valueOf(legacyTime).length() == 6) {
				date = stdFormatter.parse(legacyDt + String.valueOf(legacyTime)
						+ "000");
			}
		} catch (ParseException e) {
			log.error(
					"ParseException thrown while executing parseLegacyDateTime for params:"
							+ String.valueOf(legacyDate) + "/"
							+ String.valueOf(legacyTime), e);
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Get the default date
	 * 
	 * @return date 01/01/1900 in format MM/dd/yyyy
	 */
	public static Date getDefaultDate() {
		try {
			return dayStart(parse("MM/dd/yyyy", "01/01/1900"));
		} catch (Throwable e) {
			log.error("getDefaultDate Exception: " + e, e);
		}
		return null;
	}

	/**
	 * Method to get a legacy date as a long cyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static long getLegacyDate(Date date) {
		// get a string as yyMMdd
		String str = DateUtil.format("yyMMdd", date);
		// century marker applies does not apply for 1900 dates
		if (DateUtil.getYear(date) >= 2000) {
			str = "1" + str;
		}
		return new Long(str).longValue();
	}

	/**
	 * Add number of days to current Date and return the new Date.
	 * 
	 * @param dt
	 *            The given date
	 * @param days
	 *            The number of days to add
	 * 
	 * @return date The new Date
	 */
	public static Date addWeekDays(Date dt, int days) {
		if (isWeekend(dt)) {
			dt = nextMonday(dt);
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);

		if (days > 0) {
			for (int j = 1; j <= days; j++) {
				if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
					cal.setTime(nextMonday(cal.getTime()));
				} else {
					cal.add(Calendar.DATE, 1);
				}
			}
		} else if (days < 0) {
			for (int j = days; j <= -1; j++) {
				if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
					cal.add(Calendar.DATE, -3);
				} else {
					cal.add(Calendar.DATE, -1);
				}
			}
		}
		return cal.getTime();
	}

	/**
	 * Get the beginning of time date
	 * 
	 * @return date 01/01/1970 in format yyyyMMdd
	 */
	private static Date getMinDate() {
		try {
			return dayStart(parse("yyyyMMdd", "19700101"));
		} catch (Throwable e) {
			log.error("getMinDate Exception: " + e, e);
		}
		return null;
	}

	/**
	 * Get a max date
	 * 
	 * @return date 01/01/3000 in format yyyyMMdd
	 */
	private static Date getMaxDate() {
		try {
			return dayStart(parse("yyyyMMdd", "30000101"));
		} catch (Throwable e) {
			log.error("getMaxDate Exception: " + e, e);
		}
		return null;
	}
}
