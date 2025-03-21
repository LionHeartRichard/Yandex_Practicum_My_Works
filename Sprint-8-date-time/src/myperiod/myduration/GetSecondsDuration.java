package myperiod.myduration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class GetSecondsDuration {
	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();

		// фиксируем начало выполнения кода
		LocalDateTime start = LocalDateTime.now();

		// производим действия, время исполнения которых хотим замерить
		int num = random.nextInt(5000);
		Thread.sleep(num); // останавливаем выполнение кода на произвольное время

		// фиксируем конец выполнения кода
		LocalDateTime finish = LocalDateTime.now();

		// находим продолжительность между двумя моментами
		Duration duration = Duration.between(start, finish);

		// выводим результат
		System.out.println("Код выполнился за " + duration.getSeconds() + "." + duration.getNano() + "с.");

		LocalTime secondTime = LocalTime.of(23, 40);
		LocalTime firstTime = LocalTime.of(14, 25);

		Duration duration2 = Duration.between(firstTime, secondTime);

		System.out.println("Между двумя моментами времени:");
		System.out.println(duration2.toHours() + " часов, " + duration2.toMinutesPart() + " минут,");
		System.out.println("или " + duration2.toMinutes() + " минут.");
	}
}
