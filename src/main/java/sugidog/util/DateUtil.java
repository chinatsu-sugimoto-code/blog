package sugidog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Bean;

public class DateUtil {

	//現在時刻の取得
	@Bean
	public String getCurrentDateTime() {

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(now);

		return strDate;

	}

}
