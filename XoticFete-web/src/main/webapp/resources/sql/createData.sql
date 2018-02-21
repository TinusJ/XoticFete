-- Create Company

-- Create Events
DELETE FROM event_tags;
DELETE FROM event;

INSERT INTO public.event(
id, createddate, description, enddate, entrancefee, eventname, startdate, company_id, attachment_id)
VALUES (1, current_date, 'Karen Zoid Description', current_timestamp, 50, 'Karen Zoid Live', current_date, null, null);

INSERT INTO public.event(
id, createddate, description, enddate, entrancefee, eventname, startdate, company_id, attachment_id)
VALUES (2, current_date, 'Karlien Live Description', current_timestamp, 100, 'Karlien Live', current_date, null, null);

INSERT INTO public.event(
id, createddate, description, enddate, entrancefee, eventname, startdate, company_id, attachment_id)
VALUES (3, current_date, 'Awesome DJ''s', current_timestamp, 200, 'DJ Promo', current_date, null, null);

INSERT INTO public.event(
id, createddate, description, enddate, entrancefee, eventname, startdate, company_id, attachment_id)
VALUES (4, current_date, 'Pool Comp entry 20.', current_timestamp, 20, 'Pool Comp', current_date, null, null);

INSERT INTO public.event(
id, createddate, description, enddate, entrancefee, eventname, startdate, company_id, attachment_id)
VALUES (5, current_date, 'House Party', current_timestamp, 100, 'House Party', current_date, null, null);

-- Create Event Tags
INSERT INTO public.event_tags(
	event_id, eventtag)
	VALUES (1, 'PERFORMER');
INSERT INTO public.event_tags(
	event_id, eventtag)
	VALUES (2, 'COMPETITION');
INSERT INTO public.event_tags(
	event_id, eventtag)
	VALUES (3, 'COMPETITION');
INSERT INTO public.event_tags(
	event_id, eventtag)
	VALUES (3, 'DJ');
INSERT INTO public.event_tags(
	event_id, eventtag)
	VALUES (4, 'COMPETITION');
INSERT INTO public.event_tags(
	event_id, eventtag)
	VALUES (5, 'BAND');

-- Create Specials


-- Create Wallet


-- Create Preference

