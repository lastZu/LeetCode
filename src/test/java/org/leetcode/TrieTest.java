package org.leetcode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {
	Trie trie;

	@BeforeEach
	void setUp() {
		trie = new Trie();
		trie.insert("asdf");
	}

	@AfterEach
	void tearDown() {
		trie = null;
	}

	@Test
	void searchASDF() {
		assertTrue(trie.search("asdf"));
	}

	@Test
	void startsWithAS() {
		assertTrue(trie.startsWith("asdf"));
	}

	@Test
	void startsWithAD() {
		assertFalse(trie.startsWith("ad"));
	}



}