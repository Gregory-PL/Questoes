//Horizontal Scroll personalizado
//Bruce Cooper on 3 May 2011
//https://github.com/brucejcooper/Android-Examples/tree/master/PagingScrollerExample

package com.example.questoes_scroll_horizontal;

public interface OnPageChangeListener {
	/*
	 * This is a poorly named event listener. It gets called every time the page scroller updates its scroll position,
	 * not just when a page changes. it does this because we want to be updated while in the middle of a scroll
	 */
	
	public void onPageChange(Pager scroller);
	
	/*
	 * Called whenever a page is added or removed from the paper, so that any page indicators can update themselves.
	 * @param scroller
	 */
	
	public void onPageCountChange(Pager scroller);
}
