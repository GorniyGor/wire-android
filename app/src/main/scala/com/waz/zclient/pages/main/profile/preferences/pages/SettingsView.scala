/**
 * Wire
 * Copyright (C) 2017 Wire Swiss GmbH
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
package com.waz.zclient.pages.main.profile.preferences.pages

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.waz.threading.Threading
import com.waz.zclient.pages.main.profile.preferences.views.TextButton
import com.waz.zclient.utils.{BackStackNavigator, ViewState}
import com.waz.zclient.{R, ViewHelper}


class SettingsView(context: Context, attrs: AttributeSet, style: Int) extends LinearLayout(context, attrs, style) with ViewHelper {
  def this(context: Context, attrs: AttributeSet) = this(context, attrs, 0)
  def this(context: Context) = this(context, null, 0)

  inflate(R.layout.preferences_settings_layout)

  val navigator = inject[BackStackNavigator]

  val accountButton = findById[TextButton](R.id.settings_account)
  val optionsButton = findById[TextButton](R.id.settings_options)
  val advancedButton = findById[TextButton](R.id.settings_advanced)
  val supportButton = findById[TextButton](R.id.settings_support)
  val aboutButton = findById[TextButton](R.id.settings_about)
  val devButton = findById[TextButton](R.id.settings_dev)
  val avsButton = findById[TextButton](R.id.settings_avs)

  accountButton.onClickEvent.on(Threading.Ui) { _ => navigator.goTo(AccountViewState()) }
  optionsButton.onClickEvent.on(Threading.Ui) { _ => navigator.goTo(OptionsViewState()) }
  advancedButton.onClickEvent.on(Threading.Ui) { _ => navigator.goTo(AdvancedViewState()) }
  supportButton.onClickEvent.on(Threading.Ui) { _ => navigator.goTo(SupportViewState()) }
  aboutButton.onClickEvent.on(Threading.Ui) { _ => navigator.goTo(AboutViewState()) }
  devButton.onClickEvent.on(Threading.Ui) { _ => navigator.goTo(DevSettingsViewState()) }
  avsButton.onClickEvent.on(Threading.Ui) { _ => navigator.goTo(AvsViewState()) }
}

case class SettingsViewState() extends ViewState {

  override def name = "Settings"//TODO: resource

  override def layoutId = R.layout.preferences_settings

  override def onViewAttached(v: View) = {}

  override def onViewDetached() = {}
}
