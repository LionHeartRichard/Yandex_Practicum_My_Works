package myperiod;

import java.time.LocalDate;
import java.time.Period;
import static java.time.Month.JANUARY;

class Practicum {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		// напишите здесь свою дату рождения
		LocalDate birthday = LocalDate.of(1990, JANUARY, 1);

		Period age = Period.between(birthday, today);
		System.out.println("Ваш возраст:");
		System.out.println("Лет: " + age.getYears());
		System.out.println("Месяцев: " + age.getMonths());
		System.out.println("Дней: " + age.getDays());
	}
}
