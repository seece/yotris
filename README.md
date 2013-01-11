yotris
======

Suomenkieliset käyttöohjeet: dokumentaatio/kayttoohje.txt

A tetris clone for joululabra. This program *requires JRE 7* to run.

If you don't have Java 7, run the following commands to download JRE 7 binaries and run the game.

	mkdir yotris_dl
	cd yotris_dl
	wget http://cs.helsinki.fi/u/pekkavaa/foo/jre-7-linux-i586.gz && \
	tar -xvf jre-7-linux-i586.gz && \
	git clone https://github.com/seece/yotris.git && \
	jre1.7.0/bin/java -jar yotris/yotris-0.7.jar;
	cd ..
	

