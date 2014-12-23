package com.floydpink.android.bhagavadgita.helpers;

import android.content.Context;
import android.content.Intent;

import com.floydpink.android.bhagavadgita.data.BookData;

/**
 * Created by hari on 12/22/14.
 */
public class ShareHelper {
    private static final String baseUrl = "http://floydpink.github.io/BhagavadGita/share/";

    public static void ShareChapter(Context context, String chapterName) {
        String chapterTitle = ChapterHelper.getChapterTitle(BookData.Chapters.get(chapterName));
        Share(context, "Share " + chapterTitle, getChapterLink(chapterName),
                chapterTitle);
    }

    public static void ShareSection(Context context, String title, String queryString) {
        Share(context, "Share " + title, getSectionLink(queryString), title);
    }

    private static String getSectionLink(String queryString) {
        return String.format(baseUrl + "?%s", queryString);
    }

    private static void Share(Context context, String subject, String link, String linkTitle) {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        //noinspection deprecation
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, linkTitle);
        share.putExtra(Intent.EXTRA_TEXT, link);

        context.startActivity(Intent.createChooser(share, subject));
    }

    private static String getChapterLink(String chapterName) {
        return String.format(baseUrl + "?c=%s", BookData.ChapterIndexes.get(chapterName));
    }
}
