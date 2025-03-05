--
-- PostgreSQL database dump
--

-- Dumped from database version 15.10 (Debian 15.10-1.pgdg120+1)
-- Dumped by pg_dump version 17.2

-- Started on 2025-03-11 13:58:29 CET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE curso_ad;
--
-- TOC entry 3351 (class 1262 OID 84887)
-- Name: curso_ad; Type: DATABASE; Schema: -; Owner: root
--

CREATE DATABASE curso_ad WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE curso_ad OWNER TO root;

\connect curso_ad

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 3352 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 84889)
-- Name: books; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.books (
                              id integer NOT NULL,
                              title character varying(255) NOT NULL,
                              genre character varying(100),
                              description text,
                              author character varying(255),
                              publisher character varying(255),
                              pages integer,
                              image_url character varying(255),
                              publish_date date
);


ALTER TABLE public.books OWNER TO root;

--
-- TOC entry 214 (class 1259 OID 84888)
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.books_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.books_id_seq OWNER TO root;

--
-- TOC entry 3353 (class 0 OID 0)
-- Dependencies: 214
-- Name: books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;


--
-- TOC entry 3199 (class 2604 OID 84892)
-- Name: books id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);


--
-- TOC entry 3345 (class 0 OID 84889)
-- Dependencies: 215
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.books VALUES (1, 'Cien años de soledad', 'Novela', 'Una de las obras más importantes de la literatura hispanoamericana', 'Gabriel García Márquez', 'Sudamericana', 471, 'https://example.com/cien_anos.jpg', NULL);
INSERT INTO public.books VALUES (2, '1984', 'Distopía', 'Un mundo totalitario vigilado por el Gran Hermano', 'George Orwell', 'Secker & Warburg', 328, 'https://example.com/1984.jpg', NULL);
INSERT INTO public.books VALUES (3, 'El Principito', 'Fábula', 'Una historia filosófica con un trasfondo poético', 'Antoine de Saint-Exupéry', 'Reynal & Hitchcock', 96, 'https://example.com/principito.jpg', NULL);


--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 214
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.books_id_seq', 3, true);


--
-- TOC entry 3201 (class 2606 OID 84896)
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


-- Completed on 2025-03-11 13:58:30 CET

--
-- PostgreSQL database dump complete
--

