/*
 * Copyright (C) 2013-2022 Federico Iosue (federico@iosue.it)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.feio.android.omninotes.helpers;

import static java.util.Locale.ITALIAN;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.pixplicity.easyprefs.library.Prefs;
import it.feio.android.omninotes.BaseAndroidTestCase;
import it.feio.android.omninotes.R;
import it.feio.android.omninotes.utils.Constants;
import java.util.Locale;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LanguageHelperTest extends BaseAndroidTestCase {

  @After
  public void tearDown() {
    LanguageHelper.resetSystemLanguage(testContext);
  }

  @Test
  public void checkUtilityClassWellDefined() throws Exception {
    assertUtilityClassWellDefined(LanguageHelper.class);
  }

  @Test
  public void changeSharedPrefrencesLanguage() {
    LanguageHelper.updateLanguage(testContext, Locale.ITALY.toString());
    String language = Prefs.getString(Constants.PREF_LANG, "");
    assertEquals(Locale.ITALY.toString(), language);
  }

  @Test
  public void changeAppLanguage() {
    assertEquals(PRESET_LOCALE, LanguageHelper.getCurrentLocale(testContext));

    LanguageHelper.updateLanguage(testContext, Locale.ITALY.toString());

    assertTranslationMatches(Locale.ITALY.toString(), R.string.add_note);
  }

  @Test
  public void sameStaticStringToEnsureTranslationsAreCorrect() {
    assertTranslationMatches("ar_SA", R.string.add_note, "?????????? ????????");
    assertTranslationMatches("es_XA", R.string.add_note, "Amestar Nota");
    assertTranslationMatches("ca_ES", R.string.add_note, "Afegeix una nota");
    assertTranslationMatches("zh_CN", R.string.add_note, "????????????");
    assertTranslationMatches("zh_TW", R.string.add_note, "????????????");
    assertTranslationMatches("hr_HR", R.string.add_note, "Dodaj Bilje??ku");
    assertTranslationMatches("cs_CZ", R.string.add_note, "P??idat pozn??mku");
    assertTranslationMatches("nl_NL", R.string.add_note, "Notitie toevoegen");
    assertTranslationMatches("en_US", R.string.add_note, "Add Note");
    assertTranslationMatches("fr_FR", R.string.add_note, "Ajouter une note");
    assertTranslationMatches("km_KH", R.string.add_note, "??????????????????");
    assertTranslationMatches("de_DE", R.string.add_note, "Notiz hinzuf??gen");
    assertTranslationMatches("gl_ES", R.string.add_note, "Engadir nota");
    assertTranslationMatches("el_GR", R.string.add_note, "???????????????? ??????????????????");
    assertTranslationMatches("iw_IL", R.string.add_note, "?????????? ????????");
    assertTranslationMatches("hi_IN", R.string.add_note, "????????? ??????????????????");
    assertTranslationMatches("hu_HU", R.string.add_note, "Jegyzet hozz??ad??sa");
    assertTranslationMatches("in_ID", R.string.add_note, "Tambahkan Catatan");
    assertTranslationMatches("it_IT", R.string.add_note, "Aggiungi nota");
    assertTranslationMatches("ja_JP", R.string.add_note, "??????????????????");
    assertTranslationMatches("lo_LA", R.string.add_note, "?????????????????????????????????");
    assertTranslationMatches("lv_LV", R.string.add_note, "Pievienot piez??mi");
    assertTranslationMatches("pl_PL", R.string.add_note, "Dodaj Notatk??");
    assertTranslationMatches("pt_BR", R.string.add_note, "Adicionar nota");
    assertTranslationMatches("pt_PT", R.string.add_note, "Adicionar nota");
    assertTranslationMatches("ru_RU", R.string.add_note, "?????????????? ??????????????");
    assertTranslationMatches("sr_SP", R.string.add_note, "?????????? ??????????????");
    assertTranslationMatches("sk_SK", R.string.add_note, "Prida?? pozn??mku");
    assertTranslationMatches("sl_SI", R.string.add_note, "Dodaj bele??ko");
    assertTranslationMatches("es_ES", R.string.add_note, "A??adir Nota");
    assertTranslationMatches("sv_SE", R.string.add_note, "L??gg till Anteckning");
    assertTranslationMatches("tr_TR", R.string.add_note, "Not Ekle");
    assertTranslationMatches("uk_UA", R.string.add_note, "???????????? ??????????????");
  }

  @Test
  public void updateLanguage_systemDefault() {
    assertEquals(PRESET_LOCALE, LanguageHelper.getCurrentLocale(testContext));
    LanguageHelper.updateLanguage(testContext, null);
    assertEquals(PRESET_LOCALE, LanguageHelper.getCurrentLocale(testContext));
  }

  @Test
  public void resetSystemLanguage() {
    LanguageHelper.updateLanguage(testContext, ITALIAN.getLanguage());
    LanguageHelper.resetSystemLanguage(testContext);
    assertEquals(PRESET_LOCALE, LanguageHelper.getCurrentLocale(testContext));
  }

  @Test
  public void updateLanguage() {
    assertEquals(PRESET_LOCALE, LanguageHelper.getCurrentLocale(testContext));
    LanguageHelper.updateLanguage(testContext, ITALIAN.getLanguage());
    assertEquals(ITALIAN, LanguageHelper.getCurrentLocale(testContext));
  }

  private void assertTranslationMatches(String locale, int resourceId) {
    assertTranslationMatches(locale, resourceId, testContext.getString(resourceId));
  }

  private void assertTranslationMatches(String locale, int resourceId, String string) {
    assertEquals(string, LanguageHelper.getLocalizedString(testContext, locale, resourceId));
  }

}
