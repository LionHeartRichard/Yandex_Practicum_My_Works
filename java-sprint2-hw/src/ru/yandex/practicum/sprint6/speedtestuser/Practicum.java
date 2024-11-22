package ru.yandex.practicum.sprint6.speedtestuser;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Practicum {
	private static Map<Long, User> users = new HashMap<>();;

	public static void main(String[] args) {
		// создадим 1 миллион пользователей
		for (long i = 1; i <= 1_000_000L; i++) {
			users.put(i, new User(i, "Имя " + i));
		}

		final long startTime = System.nanoTime();
		User user = findUser(378_366L);
		final long endTime = System.nanoTime();

		System.out.println("Найден пользователь: " + user);
		System.out.println("Поиск занял " + (endTime - startTime) + " наносекунд.");
	}

	private static User findUser(Long userId) {
		return users.get(userId);
	}

	static class User {
		Long id;
		String name;

		public User(Long id, String name) {
			this.id = id;
			this.name = name;
		}

		public String toString() {
			return "User{id=" + id + ", name='" + name + "'}";
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(id, other.id);
		}

	}
}
