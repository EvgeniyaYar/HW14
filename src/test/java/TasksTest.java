import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;

public class TasksTest {
    @Test
    public void shouldFindForEpic() {
        String[] subtasks = {"bread", "water", "meat"};
        Epic epic = new Epic(1, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("water");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindForEpic() {
        String[] subtasks = {"bread", "water", "meat"};
        Epic epic = new Epic(1, subtasks);

        Assertions.assertEquals(false, epic.matches("fish"));
    }

    @Test
    public void shouldFindForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(2, "Find a job");

        Assertions.assertEquals(true, simpleTask.matches("Find a job"));
    }

    @Test
    public void shouldNotFindForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(2, "Find a job");

        Assertions.assertEquals(false, simpleTask.matches("Find myself"));
    }

    @Test
    public void shouldFindForMeetingProject() {
        Meeting meeting = new Meeting(3, "Job", "interview", "01.04.2023");

        Assertions.assertEquals(true, meeting.matches("interview"));
    }

    @Test
    public void shouldFindForMeetingTopic() {
        Meeting meeting = new Meeting(3, "Job", "interview", "01.04.2023");

        Assertions.assertEquals(true, meeting.matches("Job"));
    }

    @Test
    public void shouldFindForMeetingStart() {
        Meeting meeting = new Meeting(3, "Job", "interview", "01.04.2023");

        Assertions.assertEquals(true, meeting.matches("01.04.2023"));
    }

    @Test
    public void shouldNotFindForMeeting() {
        Meeting meeting = new Meeting(3, "Job", "interview", "01.04.2023");

        Assertions.assertEquals(false, meeting.matches("Spa"));
    }
}
