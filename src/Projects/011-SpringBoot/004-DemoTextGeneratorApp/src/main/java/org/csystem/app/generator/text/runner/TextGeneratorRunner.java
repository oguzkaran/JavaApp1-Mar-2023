package org.csystem.app.generator.text.runner;

import com.karandev.io.util.console.Console;
import com.karandev.util.spring.datetime.BeanName;
import org.csystem.util.scheduler.Scheduler;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

@Component
public class TextGeneratorRunner implements ApplicationRunner {
    private final Scheduler m_scheduler;
    private final BufferedWriter m_bufferedWriter;
    private final ApplicationContext m_applicationContext;
    private final RandomGenerator m_randomGenerator;
    private final DateTimeFormatter m_dateTimeFormatter;

    @Value("${generator.min}")
    private int m_min;
    @Value("${generator.bound}")
    private int m_bound;
    @Value("${generator.count}")
    private int m_count;

    @Value("${generator.n}")
    private int m_n;

    private void writeTextCallback()
    {
        try {
            var nowStr = m_dateTimeFormatter.format(m_applicationContext.getBean(BeanName.CURRENT_DATE_TIME, LocalDateTime.class));
            var text = StringUtil.getRandomTextEN(m_randomGenerator, m_randomGenerator.nextInt(m_min, m_bound)) + " " + nowStr;

            m_bufferedWriter.write(text);
            m_bufferedWriter.newLine();
            m_bufferedWriter.flush();
        }
        catch (IOException ignore) {
            Console.Error.writeLine("Problem occurred while writing text!...:");
            m_scheduler.cancel();
        }
    }

    private void textGeneratorCallback()
    {
        if (m_n-- <= 0)
            m_scheduler.cancel();
        else
            IntStream.range(0, m_count).forEach(i -> writeTextCallback());
    }

    public TextGeneratorRunner(Scheduler scheduler, BufferedWriter bufferedWriter, ApplicationContext applicationContext,
                               RandomGenerator randomGenerator,
                               @Qualifier(BeanName.DATE_TIME_FORMATTER_TR) DateTimeFormatter dateTimeFormatter)
    {
        m_scheduler = scheduler;
        m_bufferedWriter = bufferedWriter;
        m_applicationContext = applicationContext;
        m_randomGenerator = randomGenerator;
        m_dateTimeFormatter = dateTimeFormatter;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_scheduler.schedule(this::textGeneratorCallback);
    }
}
