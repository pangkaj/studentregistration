--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2015-04-09 17:06:43 BDT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'ISO_8859_8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 38962)
-- Name: users; Type: TABLE; Schema: public; Owner: daffodil; Tablespace: 
--

CREATE TABLE users (
    username character varying(45) NOT NULL,
    password character varying(45) NOT NULL,
    enabled smallint DEFAULT 1 NOT NULL
);


ALTER TABLE public.users OWNER TO daffodil;

--
-- TOC entry 1977 (class 0 OID 38962)
-- Dependencies: 171
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: daffodil
--

COPY users (username, password, enabled) FROM stdin;
sadh	123456	1
pangkaj	123456	1
rajib	123456	1
\.


--
-- TOC entry 1869 (class 2606 OID 38967)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: daffodil; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


-- Completed on 2015-04-09 17:06:43 BDT

--
-- PostgreSQL database dump complete
--

