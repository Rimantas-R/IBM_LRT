package lt.r.lrtlive.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import lt.r.lrtlive.models.LiveItem;

@Service
public class ParserService {

	public List<LiveItem> stoutP() throws IOException {
		List<LiveItem> liveItems = new ArrayList<>();
		Document doc = Jsoup.connect("https://www.lrt.lt/mediateka/tiesiogiai").get();
		Elements elements = doc.select("#tvprog");

		int elSize = elements.size();
		if (elSize == 0) {
			liveItems.add(new LiveItem("something vent wrong", " -- ", " -- "));
			return liveItems;
		}
		Elements chElements = elements.select(".channel-item");
		Iterator<Element> chIt = chElements.iterator();
		Elements schedElements = elements.select(".data-block__text");
		Iterator<Element> schIt = schedElements.iterator();
		Elements titleElements = elements.select(".channel-item__title");
		Iterator<Element> titleIt = titleElements.iterator();
		while (chIt.hasNext()) {
			String chSt = chIt.next().attr("data-tvprogname");
			String schSt = schIt.hasNext() ? schIt.next().text() : " -- ";
			String titlSt = titleIt.hasNext() ? titleIt.next().text() : " -- ";
			liveItems.add(new LiveItem(chSt, titlSt, schSt));
		}

		for (LiveItem i : liveItems) {
			System.out.println(i);
		}

		System.out.println("Noting?" + elSize);
		return liveItems;
	}

}
