package com.ceiba.biblioteca.prestamo.domain.utils;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;

public class MDateUtil {

	private static final String APP_ZONE_ID = "GMT-05:00";
	public static final String FORMATO_FECHA_HORA_SQL = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMATO_FECHA = "yyyy/MM/dd";
	public static final String FORMATO_FECHA_HORA = "yyyy/MM/dd HH:mm";
	public static final String FORMATO_FECHA_HORA_12 = "yyyy/MM/dd hh:mm:ss a";
	public static Locale tmpLocaleColombia = new Locale("es", "CO");
	public static SimpleDateFormat sdf;
	public static SimpleDateFormat sdfMaps;

//	IntFunction<TemporalAdjuster> getFechaSinSabadoYDomingos = days -> TemporalAdjusters.ofDateAdjuster(date -> {
//		LocalDate baseDate = days > 0 
//				? date.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY))
//				: days < 0 ? date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)) : date;
//		int businessDays = days + Math.min(Math.max(baseDate.until(date).getDays(), -4), 4);
//		return baseDate.plusWeeks(businessDays / 5).plusDays(businessDays % 5);
//	});

	static {
		sdf = new SimpleDateFormat(FORMATO_FECHA_HORA_12);
	}

	public static void main(String[] args) {
		LocalDate today = LocalDate.of(2023, 01, 15);
//        LocalDate today = LocalDate.of(2020, 5, 5);

//		System.out.println(addBusinessDays(today, 5, Optional.empty())); // 2020-05-15
//		System.out.println(addBusinessDays(today, 8, Optional.of(holidays))); // 2020-05-18

		System.out.println(subtractBusinessDays(today, 20, Optional.empty())); // 2020-04-22
//		System.out.println(subtractBusinessDays(today, 8, Optional.of(holidays))); // 2020-04-21
	}

	public static String getStringFechaFormato12(Date fecha) {
		if (fecha == null) {
			return "";
		}
		return sdf.format(fecha);
	}

	public static String getStringFecha(LocalDate fecha) {
		if (fecha == null) {
			return "";
		}
		return fecha.format(DateTimeFormatter.ofPattern(FORMATO_FECHA, getColombiaLocale()));
	}

	public static String obtenerFechaHoraSql(Date fecha) {
		if (fecha == null) {
			return "";
		}
		return convertirEnLocalDateTime(fecha)
				.format(DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA_SQL, getColombiaLocale()));
	}

	public static Locale getColombiaLocale() {
		return tmpLocaleColombia;
	}

	public static long getDiasEntreDosFechas(LocalDate dateDesde, LocalDate dateHasta) {
		return ChronoUnit.DAYS.between(dateDesde, dateHasta);
	}

	public static long getMesesEntreDosFechas(LocalDate dateDesde, LocalDate dateHasta) {
		return ChronoUnit.MONTHS.between(dateDesde, dateHasta);
	}

	public static long getAnosEntreDosFechas(LocalDate dateDesde, LocalDate dateHasta) {
		return ChronoUnit.YEARS.between(dateDesde, dateHasta);
	}

	public static Date obtenerFechaHoraLocalDate() {
		return convertirEnDate(LocalDateTime.now());
	}

	public static LocalDate getLocalDateNow() {
		LocalDate localDate = LocalDate.now(ZoneId.of(APP_ZONE_ID));
		return localDate;
	}

	public static Date convertirEnDate(LocalDateTime local) {
		if (local == null) {
			return null;
		}
		Instant instant = local.atZone(ZoneId.of(APP_ZONE_ID)).toInstant();
		return Date.from(instant);
	}

	public static Date convertirEnDate(LocalDate localDate) {
		if (localDate == null) {
			return null;
		}
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.of(APP_ZONE_ID)));
		return Date.from(instant);
	}

	public static LocalDateTime convertirEnLocalDateTime(Date dateToConvert) {
		if (dateToConvert == null) {
			return null;
		}
		return dateToConvert.toInstant().atZone(ZoneId.of(APP_ZONE_ID)).toLocalDateTime();
	}

	public static int getDay(LocalDate fecha) {
		if (fecha == null) {
			return 0;
		}

		return fecha.getDayOfMonth();
	}

	public static int getDay(Date fecha) {
		return getDay(convertirEnLocalDate(fecha));
	}

	public static int getYear(LocalDate fecha) {
		if (fecha == null) {
			return 0;
		}

		return fecha.getYear();
	}

	public static int getYear(Date fecha) {
		return getYear(convertirEnLocalDate(fecha));
	}

	public static int getMonth(LocalDate fecha) {
		if (fecha == null) {
			return 0;
		}
		return fecha.getMonthValue();
	}

	public static int getMonth(Date fecha) {
		return getMonth(convertirEnLocalDate(fecha));
	}

	public static LocalDate convertirEnLocalDate(Date dateToConvert) {
		if (dateToConvert == null) {
			return null;
		}
		return dateToConvert.toInstant().atZone(ZoneId.of(APP_ZONE_ID)).toLocalDate();
	}

	public static LocalDate addBusinessDays(LocalDate localDate, int days, Optional<List<LocalDate>> holidays) {
		if (localDate == null || days <= 0 || holidays == null) {
			throw new IllegalArgumentException("Invalid method argument(s) " + "to addBusinessDays(" + localDate + ","
					+ days + "," + holidays + ")");
		}

		Predicate<LocalDate> isHoliday = date -> holidays.isPresent() ? holidays.get().contains(date) : false;
		Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
				|| date.getDayOfWeek() == DayOfWeek.SUNDAY;

		LocalDate result = localDate;
		while (days > 0) {
			result = result.plusDays(1);
			if (isHoliday.or(isWeekend).negate().test(result)) {
				days--;
			}
		}
		return result;
	}

	public static LocalDate subtractBusinessDays(LocalDate localDate, int days, Optional<List<LocalDate>> holidays) {
		if (localDate == null || days <= 0 || holidays == null) {
			throw new IllegalArgumentException("Invalid method argument(s) " + "to subtractBusinessDays(" + localDate
					+ "," + days + "," + holidays + ")");
		}

		Predicate<LocalDate> isHoliday = date -> holidays.isPresent() ? holidays.get().contains(date) : false;
		Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
				|| date.getDayOfWeek() == DayOfWeek.SUNDAY;

		LocalDate result = localDate;
		while (days > 0) {
			result = result.minusDays(1);
			if (isHoliday.or(isWeekend).negate().test(result)) {
				days--;
			}
		}
		return result;
	}

}
