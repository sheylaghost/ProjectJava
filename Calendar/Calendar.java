import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.YearMonth;

public class Calendar extends JFrame {

    private JComboBox<String> monthBox;
    private JComboBox<Integer> yearBox;
    private JPanel calendarPanel;

    private final String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    public Calendar() {
        setTitle("Calendar");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top panel (month and year)
        JPanel topPanel = new JPanel();
        monthBox = new JComboBox<>(months);
        yearBox = new JComboBox<>();

        for (int i = 1990; i <= 2035; i++) {
            yearBox.addItem(i);
        }

        LocalDate now = LocalDate.now();
        monthBox.setSelectedIndex(now.getMonthValue() - 1);
        yearBox.setSelectedItem(now.getYear());

        topPanel.add(monthBox);
        topPanel.add(yearBox);

        add(topPanel, BorderLayout.NORTH);

        // Calendar panel
        calendarPanel = new JPanel(new GridLayout(0, 7));
        add(calendarPanel, BorderLayout.CENTER);

        monthBox.addActionListener(e -> updateCalendar());
        yearBox.addActionListener(e -> updateCalendar());

        updateCalendar();
        setVisible(true);
    }

    private void updateCalendar() {
        calendarPanel.removeAll();

        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : days) {
            JLabel label = new JLabel(day, SwingConstants.CENTER);
            label.setFont(label.getFont().deriveFont(Font.BOLD));
            calendarPanel.add(label);
        }

        int month = monthBox.getSelectedIndex() + 1;
        int year = (int) yearBox.getSelectedItem();

        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate firstDay = yearMonth.atDay(1);
        int startDay = firstDay.getDayOfWeek().getValue() % 7;

        for (int i = 0; i < startDay; i++) {
            calendarPanel.add(new JLabel(""));
        }

        for (int day = 1; day <= daysInMonth; day++) {
            JLabel label = new JLabel(String.valueOf(day), SwingConstants.CENTER);
            calendarPanel.add(label);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calendar::new);
    }
}
