$(function()
{
	$("span .strong").each(function()
		{
			var obj = $(this);

			if(obj.text() == "Deprecated.")
			{
				$(this).addClass("deprecated");
			}
		});
});