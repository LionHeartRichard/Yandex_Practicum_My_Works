package ru.yandex.practicum.sprint6.avia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Practicum {
	// Пример списка пассажиров (на самом деле их больше)
	private static List<String> passengerNames = List.of("Василий Петров", "Анна Ягирская", "Виктория Сотова",
			"Игорь Серов", "Людмила Ульянова");

	public static void main(String[] args) {
		Map<String, Integer> seats = assignSeats(passengerNames);
		System.out.println("Места пассажиров: " + seats);
	}

	public static Map<String, Integer> assignSeats(List<String> passengerNames) {
		// Тут нужно написать код, который будет распределять места в самолёте ✈️
		Map<String, Integer> seats = new HashMap<>();
		int count = 0;
		for (String passenger : passengerNames) {
			seats.put(passenger, ++count);
		}
		return seats;
	}
}