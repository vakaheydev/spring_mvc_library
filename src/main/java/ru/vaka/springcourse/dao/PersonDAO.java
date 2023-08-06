package ru.vaka.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vaka.springcourse.models.Book;
import ru.vaka.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Book> getBooksByPersonId(int person_id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id = ?",
                new BeanPropertyRowMapper<>(Book.class), person_id);
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?", new BeanPropertyRowMapper<>(Person.class), id)
        .stream().findAny().orElse(null);
    }

    public Optional<Person> show(String email) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE EMAIL = ?",
                new BeanPropertyRowMapper<>(Person.class), email).stream().findAny();
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(fullname, birthyear) VALUES (?, ?)", person.getFullname(),
                person.getBirthyear());
    }

    public void update(Person person) {
        jdbcTemplate.update("UPDATE Person SET fullname=?, birthyear=? WHERE id = ?", person.getFullname(),
                person.getBirthyear(), person.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }
}


//    /////////
//    // Тестирование производительности пакетной вставки
//    /////////
//
//    public void testMultipleUpdate() {
//        List<Person> people = create1000people();
//
//        long before = System.currentTimeMillis();
//
//        for(Person person : people) {
//            jdbcTemplate.update("INSERT INTO Person VALUES (?, ?, ?, ?)", person.getId(), person.getName(),
//                    person.getAge(), person.getEmail());
//        }
//
//        long after = System.currentTimeMillis();
//
//        System.out.println("Время, затраченное на 1000 вставок в коносль - " + (after - before));
//    }
//
//    public void testBatchUpdate() {
//        List<Person> people = create1000people();
//
//        long before = System.currentTimeMillis();
//
//        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES (?, ?, ?, ?)", new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                ps.setInt(1, people.get(i).getId());
//                ps.setString(2, people.get(i).getName());
//                ps.setInt(3, people.get(i).getAge());
//                ps.setString(4, people.get(i).getEmail());
//            }
//
//            @Override
//            public int getBatchSize() {
//                return people.size();
//            }
//        });
//
//        long after = System.currentTimeMillis();
//        System.out.println("Batch: Время, затраченное на 1000 вставок в коносль - " + (after - before));
//
//    }
//
//    private List<Person> create1000people () {
//        List<Person> people = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            people.add(new Person(i, "Name" + i, 30, "test" + i + "@mail.ru", "some address")); }
//        return people;
//    }
//
//}
