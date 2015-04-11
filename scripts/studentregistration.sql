--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2015-04-11 16:54:22 BDT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 174 (class 3079 OID 11789)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1999 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 38954)
-- Name: student; Type: TABLE; Schema: public; Owner: daffodil; Tablespace: 
--

CREATE TABLE student (
    id character varying(16) NOT NULL,
    first_name character varying(10),
    last_name character varying,
    birthdate date,
    regid bigint
);


ALTER TABLE public.student OWNER TO daffodil;

--
-- TOC entry 173 (class 1259 OID 38980)
-- Name: user_role_id_seq; Type: SEQUENCE; Schema: public; Owner: daffodil
--

CREATE SEQUENCE user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_role_id_seq OWNER TO daffodil;

--
-- TOC entry 172 (class 1259 OID 38968)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: daffodil; Tablespace: 
--

CREATE TABLE user_roles (
    user_role_id integer DEFAULT nextval('user_role_id_seq'::regclass) NOT NULL,
    username character varying(45) NOT NULL,
    user_role character varying(45) NOT NULL
);


ALTER TABLE public.user_roles OWNER TO daffodil;

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
-- TOC entry 1988 (class 0 OID 38954)
-- Dependencies: 170
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: daffodil
--

COPY student (id, first_name, last_name, birthdate, regid) FROM stdin;
12	test	test1	1985-11-26	12345
\.


--
-- TOC entry 2000 (class 0 OID 0)
-- Dependencies: 173
-- Name: user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: daffodil
--

SELECT pg_catalog.setval('user_role_id_seq', 4, true);


--
-- TOC entry 1990 (class 0 OID 38968)
-- Dependencies: 172
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: daffodil
--

COPY user_roles (user_role_id, username, user_role) FROM stdin;
1	sadh	ROLE_ADMIN
3	rajib	ROLE_USER
4	pangkaj	ROLE_ADMIN
\.


--
-- TOC entry 1989 (class 0 OID 38962)
-- Dependencies: 171
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: daffodil
--

COPY users (username, password, enabled) FROM stdin;
sadh	123456	1
pangkaj	123456	1
rajib	123456	1
\.


--
-- TOC entry 1873 (class 2606 OID 38958)
-- Name: student_pkey; Type: CONSTRAINT; Schema: public; Owner: daffodil; Tablespace: 
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- TOC entry 1877 (class 2606 OID 38972)
-- Name: user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: daffodil; Tablespace: 
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_role_id);


--
-- TOC entry 1879 (class 2606 OID 38974)
-- Name: user_roles_user_role_username_key; Type: CONSTRAINT; Schema: public; Owner: daffodil; Tablespace: 
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_user_role_username_key UNIQUE (user_role, username);


--
-- TOC entry 1875 (class 2606 OID 38967)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: daffodil; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- TOC entry 1880 (class 2606 OID 38975)
-- Name: user_roles_username_fkey; Type: FK CONSTRAINT; Schema: public; Owner: daffodil
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_username_fkey FOREIGN KEY (username) REFERENCES users(username);


--
-- TOC entry 1998 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-04-11 16:54:22 BDT

--
-- PostgreSQL database dump complete
--

